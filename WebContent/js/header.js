var menuFlag = 0;
$("#menu").on('click', function () {
    if (menuFlag == 0) {
        $(this).css({
                "color": "#284e75",
                "transform": "rotate(90deg)"
            }
        );
        $("#arrowWrap").fadeIn();
        menuFlag = 1;
    } else {
        $(this).css({
                "color": "rgba(0,0,0,.5)",
                "transform": "rotate(0deg)"
            }
        );
        $("#arrowWrap").fadeOut();
        menuFlag = 0;
    }//if~else end
})// click end
