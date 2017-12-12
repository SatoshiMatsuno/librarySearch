$(function() {
	$("input[type='submit']").click(function() {
		
		var errorMsg = "";
		
		if ($("input[name='userId']").val() === "") {
			errorMsg = "ユーザIDが入力されていません\n";
		} 
		
		if ($("input[name='password']").val() === "") {
			errorMsg += "パスワードが入力されていません";
		} 
		
		if (errorMsg.length != 0) {
			alert(errorMsg);
			return false;
			
		} else {
			return true;
		}
	});
});