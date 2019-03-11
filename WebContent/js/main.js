    $("#moreBtnWrap a button").on('click',function () {
        var height =$('#contentWrap').css("height");
        var heightNum = parseInt(height.substr(0,height.indexOf('px')))+110;
        $('#contentWrap').css({
            "height":heightNum ,
            "transition": "1s ease"
        });
    })