$("#inputBox input").on("keyup", function() {
	var titleVal = $(this).val();
	if (titleVal.length > 50) {
		alert("50자 까지 입력이 가능합니다.");
		titleVal = titleVal.substring(0, 50);
		$(this).val(titleVal);
		$(this).focus();
	}
});

$("#txt").on('keyup', function() {
	var txtText = $(this).val();
	var txtNum = txtText.length;
	if (txtNum > 1000) {
		alert("1000자 까지 입력이 가능합니다.");
		txtText = txtText.substring(0, 1000);
		$("#txt").val(txtText).focus();
	}
});
var $form = $("#contentWrap form");
var $title = $("#title");
var $txt = $("#txt");

$form.submit(function() {
	var titleVal = $title.val();
	var txtVal = $txt.val();

	if (titleVal == "" || txtVal == "") {
		alert("게시글을 작성해주세요")
		return false;
	}
});
