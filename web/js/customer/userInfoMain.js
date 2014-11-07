
require.config({
    paths: {
        jquery: "jquery-1.11.1.min",
        validate: "jquery.validate.min"
    }
});

require(["jquery",  "common", "userInfo", "jquery.Jcrop"], function ($) {
    var img_top_margin,img_left_margin,img_width,img_height;//最后使用的2个变量

    jQuery(function($){

        // Create variables (in this scope) to hold the API and image size
        var jcrop_api,
            boundx,
            boundy,
        // Grab some information about the preview pane
            $preview = $('#preview-pane'),
            $pcnt = $('#preview-pane .preview-container'),
            $pimg = $('#preview-pane .preview-container img'),

            xsize = $pcnt.width(),
            ysize = $pcnt.height();


        $('#target').Jcrop({
            onChange: updatePreview,
            onSelect: updatePreview,
            aspectRatio: xsize / ysize,
            setSelect: [0,0,150,150],

        },function(){
            // Use the API to get the real image size
            var bounds = this.getBounds();
            boundx = bounds[0];
            boundy = bounds[1];
            // Store the API in the jcrop_api variable
            jcrop_api = this;

            // Move the preview into the jcrop container for css positioning
            $preview.appendTo(jcrop_api.ui.holder);
        });

        function updatePreview(c)
        {
            if (parseInt(c.w) > 0)
            {
                var rx = xsize / c.w;
                var ry = ysize / c.h;
                console.log("new width:"+Math.round(rx * boundx) );
                console.log("new height:"+Math.round(ry * boundy) );

                console.log("marginTop:"+Math.round(ry * c.y));
                console.log("marginLeft:"+Math.round(rx * c.x));


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
        };

    });
});


