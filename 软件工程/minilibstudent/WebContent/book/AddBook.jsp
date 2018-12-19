<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加图书</title>
</head>
<body background="../photo/3.jpg">
${message}
<form method="post" action="addTitleManageTitlesAction.action">

图书类别：
<select name="book.typeid">
	<c:forEach items="${requestScope.allTypeList}" var="booktype" varStatus="status">
	<option value="${booktype.codeId}">${booktype.codeName }
	</c:forEach>
</select><br>

<table>
  <tr><td>分    类：</td><td><input type="text" name="book.typeid" value=""></td></tr>
  <tr><td>ISBN：</td><td><input type="text" name="book.isbn" value=""></td></tr>
  <tr><td>书    名：</td><td><input type="text" name="book.title" value=""></td></tr>
  <tr><td>作者名：</td><td><input type="text" name="book.authors" value=""></td></tr>
  <tr><td>出版社：</td><td><input type="text" name="book.pressid" value=""></td></tr>
  <tr><td><input type="submit" name = "sumbit" value = "增加图书"></td></tr>
</table>

</body>
</html>