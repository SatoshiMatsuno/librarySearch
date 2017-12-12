$(function() {
	$("input[type='submit']").click(function() {

		var errorMsg = "";

		if ($("input[name='title']").val() === "") {
			errorMsg = "書籍名が入力されていません\n";
		}

		if ($("input[name='kana']").val() === "") {
			errorMsg += "ふりがなが入力されていません\n";
		}

		if ($("input[name='author']").val() === "") {
			errorMsg += "著作者が入力されていません\n";
		}

		if ($("input[name='compactDiscNum']").val() === "") {
			errorMsg += "付属CD枚数が入力されていません\n";
		}

		if (!$("input[name='compactDiscNum']").val().match(/^[0-9]+$/)) {
			errorMsg += "CD枚数には0～9の半角数字を入れてください\n";
		}

		if ($("input[name='publisher']").val() === "") {
			errorMsg += "出版社が入力されていません\n";
		}

		// inputの値の取得
		var firstDate = $("input[name = 'firstDate']").val();


		// 画面から取得した日付の分割
		var splitDate = new Array(3);
		splitDate = firstDate.split("-");
		var year = splitDate[0];
		var month = splitDate[1];
		var day = splitDate[2];

		dt = new Date(year, month - 1, day);

		// 日付判定
		if (!(dt.getFullYear() == year && dt.getMonth() == month - 1 && dt.getDate() == day)) {
			errorMsg += "日付が正しくありません";
		}

		if (errorMsg.length != 0) {
			alert(errorMsg);
			return false;

		} else {
			alert("本当に登録しますか？");
			return true;

		}

	});
});