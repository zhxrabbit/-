<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加出版社</title>
</head>
<body background="../photo/3.jpg">
${message}

<form method="post" action="addCodePressManageCodeAction.action">

现存出版社：
<select name="">
	<c:forEach items="${requestScope.bookCodePressList}" var="booktype" varStatus="status">
	<option value="${booktype.codeId}">${booktype.codeName}
	</c:forEach>
</select><br>

<table>
  <tr><td>出版社编号：</td><td><input type="text" name="code.codeId" value=""></td></tr>
  <tr><td>出版社名称：</td><td><input type="text" name="code.codeName" value=""></td></tr>
  <tr><td><input type="submit" name = "sumbit" value = "增加出版社"></td></tr>
</table>


</body>
</html>