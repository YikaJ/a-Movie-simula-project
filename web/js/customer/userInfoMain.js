
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

require(["jquery",  "common", "userInfo", "jquery.Jcrop", "ajaxfileupload"], function ($) {
    $(document).on("change", "#imgFile", function () {
        var img_top_margin, img_left_margin, img_width, img_height;//最后使用的2个变量
        var jcrop_api,
            boundx,
            boundy,

            $target = $("#target"),
            $preview = $('#preview-pane'),
            $pcnt = $('#preview-pane .preview-container'),
            $pimg = $('#preview-pane .preview-container img'),

            xsize = $pcnt.width(),
            ysize = $pcnt.height();

        /*
         *
         * 此处ajax上传图片
         *
         * */

        $.ajaxFileUpload({
            url: "/support/uploadImage.do",
            secureuri: false,
            fileElementId: "imgFile",
            dataType: "json",
            success: function (data) {
                if (data.response) {
                    $target.attr("src", data.msg).Jcrop({
                        onChange: updatePreview,
                        onSelect: updatePreview,
                        aspectRatio: xsize / ysize,
                        setSelect: [0,0,150,150]
                    },function(){
                        var bounds = this.getBounds();
                        boundx = bounds[0];
                        jcrop_api = this;
                        $preview.appendTo(jcrop_api.ui.holder);
                        $preview.css({
                            top: 0,
                            right: -220
                        });
                        $target.css("height", "auto");
                    });
                    $pimg.attr("src", data.msg);

                } else {
                    alert(data.msg);
                }
            }
        });
        function updatePreview(c){
            if (parseInt(c.w) > 0){
                var rx = xsize / c.w;
                var ry = ysize / c.h;

                img_top_margin=c.y;
                img_left_margin=c.x;
                img_width=c.w;
                img_height=c.h;

                $pimg.css({
                    width: Math.round(rx * boundx) + 'px',
                    height: Math.round(ry * boundy) + 'px',
                    marginLeft: '-' + Math.round(rx * c.x) + 'px',
                    marginTop: '-' + Math.round(ry * c.y) + 'px'
                });
            }
            $("#x1").val(c.x);
            $("#y1").val(c.y);
            $("#x2").val(c.x2);
            $("#y2").val(c.y2);
            $("#picWidth").val(c.w);
            $("#picHeight").val(c.h);
        }

    });
});


