
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

require(["jquery",  "common", "userImgjs", "jquery.Jcrop", "ajaxfileupload"], function ($) {
    var $imgContent = $("#imgContent"),
        $preview = $("#preview"),
        $pimg = $("#preview img");
    var $img, img_top_margin, img_left_margin, img_width, img_height, x, y, shotWidth, shotHeight, scale, imgWidth;//最后使用的2个变量
    var boundx,
        boundy;
    var xsize = $preview.width(),   //预览框的宽高
        ysize = $preview.height();
    var reload;
    $(document).on("change", "#imgFile", function () {
        if ($(".jcrop-holder").length > 0) {
            $img.remove();
            $img = $("<img alt='上传你的头像'>");
            $img.appendTo($imgContent);
            reload();
        }else{
            $img = $("#imgContent img");
        }
        $.ajaxFileUpload({
            url: "/support/uploadImage.do",
            secureuri: false,
            fileElementId: "imgFile",
            dataType: "json",
            success: function (data) {
                if (data.response) {
                    $img.attr("src", data.msg).Jcrop({
                        onChange: updatePreview,
                        onSelect: updatePreview,
                        aspectRatio: xsize / ysize,
                        setSelect: [0, 0, 64, 64]
                    }, function () {
                        $pimg.attr("src", data.msg);//预览图地址一致
                        $("#imgPath").val(data.msg);
                        //获取图片的实际尺寸，数组，width,height
                        var bounds = this.getBounds();
                        boundx = bounds[0];
                        boundy = bounds[1];
                        var marginLeft = ($imgContent.width() - boundx) / 2,
                            marginTop = ($imgContent.height() - boundy) / 2;

                        $(".jcrop-holder").css({
                            marginLeft: marginLeft + "px",
                            marginTop: marginTop + "px"
                        });
                        //图片未被压缩的尺寸
                        imgWidth = data.width;
                        scale = imgWidth / boundx;    ///原图片与压缩后的图片的比例

                        var that = this;
                        //闭包返回清除Jcrop方法
                        reload = function () {
                            that.destroy();
                        }
                    })
                } else {
                    alert(data.msg);
                }
            }
        });

        function updatePreview(c) {
            if (parseInt(c.w) > 0) {
                var rx = xsize / c.w;
                var ry = ysize / c.h;

                //计算还原大小后的xy坐标
                x = Math.round(c.x * scale);
                y = Math.round(c.y * scale);
                shotWidth = Math.round(c.w * scale);
                shotHeight = Math.round(c.h * scale);

                img_top_margin = c.y;
                img_left_margin = c.x;



                img_width = c.w;
                img_height = c.h;

                $pimg.css({
                    width: Math.round(rx * boundx) + 'px',
                    height: Math.round(ry * boundy) + 'px',
                    marginLeft: '-' + Math.round(rx * c.x) + 'px',
                    marginTop: '-' + Math.round(ry * c.y) + 'px'
                });
            }
        }
    });
    //保存图片
    $("#uploadImg").click(function(){
        $("#x").val(x);
        $("#y").val(y);
        $("#picWidth").val(shotWidth);
        $("#picHeight").val(shotHeight);

        var form = $("#imageShot").serialize();
        $.ajax({
            url : "/support/imageShot.do",
            type : "POST",
            data : form,
            dataType : "json",
            success : function(response){
                window.location.reload();
            }
        });
    })
});


