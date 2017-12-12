<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "/WEB-INF/jsp/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍管理</title>
<script type="text/javascript" src="js/jquery.js"></script>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src = "js/entryInfo.js"></script>
</head>
<link rel="stylesheet" href="style.css" type="text/css">
<body>
	<h1>登録</h1>
	<hr>
	<br>
	<br>
	<div class = "EntryInfo" >
		<form action="/librarySearch/Entry" method="post" name = "EntryInfo" novalidate>
			分類
			<select name = "genreCode" >
			<c:if test = "${firstPramGenreName != 'blank'}" >
			<option value = "${firstPramGenreName}" ></option>
			</c:if>
			<c:if test = "${firstPramGenreName == 'blank'}" >
			<option value = "${firstPramGenreName}" selected ></option>
			</c:if>
			<c:forEach var = "genre" items = "${genreList}">
				<c:choose>
				<c:when test = "${genre.genreName == firstPramGenreName}">
				<option value = "${genre.genreCode}" selected >${firstPramGenreName}</option>
				</c:when>
				<c:otherwise>
				<option value = "${genre.genreCode}">${genre.genreName}</option>
				</c:otherwise>
				</c:choose>
			</c:forEach>
			</select>
			<br>
			書籍名<input type= "text" name="title"><br>
			ふりがな<input type= "text" name="kana"><br>
			著作者<input type= "text" name="author"><br>
			付属CD<input type= "text" name="compactDiscNum" maxlength="1">枚<br>
			備考<textarea name= "remarks" cols = 20 rows = 3></textarea><br>
			出版社<input type= "text" name="publisher"><br>
			発効日<input type = "date" name = "firstDate" autocomplete="off"><br>
	<br>
	<br>
			<input type="submit" value="登録" >
		</form>
	</div>
	<div class = "backButton">
		<form action="/librarySearch/Entry" method="get">
			<input type="submit" value="戻る">
		</form>
	</div>
</body>
</html>