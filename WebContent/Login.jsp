<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src = "js/login.js"></script>
</head>
<link rel="stylesheet" href="style.css" type="text/css">
<body>
	<h1>ログイン</h1>
	<hr>
	<div class = "LoginInfo" >
		<form action="/librarySearch/Login" method="post">
			ユーザーID<input type="text" name="userId" maxlength="15"><br>
			パスワード<input type="password" name="password" maxlength="15"><br>
			<input type="submit" value="ログイン">
		</form>
	</div>
	<div class = "error">
	<p>
	<c:forEach var = "errorMsg" items = "${errorMsgList}">
	${errorMsg}<br>
	</c:forEach>
	</p>
	</div>
</body>
</html>