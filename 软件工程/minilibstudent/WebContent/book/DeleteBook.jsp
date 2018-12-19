<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除图书</title>
</head>
<body background="../photo/3.jpg">
<form action="deleteTitleManageTitlesAction.action" method="post">
  <input type="text" name=book.title>
  <input type="submit" value="删除图书">
</form>

</body>
</html>