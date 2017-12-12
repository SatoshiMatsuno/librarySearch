<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理</title>
</head>
<link rel="stylesheet" href="style.css" type="text/css">
<body>
	<h1>検索</h1>
		<div class = "userName">
		ログインID：${loginUserInfo.userName}
		</div>
	<hr>
	<form action="/librarySearch/Search" method="get">
		<div class = "Button" >
			<div class = "toEntryView">
				<input type="submit" value="登録画面へ">
			</div>
			<div class = "logoutButton">
				<input type = "submit" value = "ログアウト">
			</div>
		</div>
		<div class = "SearchInfo" >
			分類
			<select name = "genre" >
			<option value = "blank" selected></option>
			<c:forEach var = "genre" items = "${genreList}">
			<option value = "${genre.genreName}">${genre.genreName}</option>
			</c:forEach>
			</select>
			<br>
			№<input type="text" name="bookNum"><br>
			<input type = "submit" value = "検索">
		</div>
	</form>	
</body>
</html>