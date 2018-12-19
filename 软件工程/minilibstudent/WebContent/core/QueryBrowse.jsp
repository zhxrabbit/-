<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询借阅页面</title>
</head>
<body background="../photo/3.jpg">
<form method="post" action="findBrowseManageBrowseAction.action">
    用户编号：<input type="text" name="record.userid" id="context" value=""><br>
    图书编号：<input type="text" name="record.bookid" id="context" value=""><br>
	<input type="submit" name="submit" value="查询借阅"><br>
</form>

</body>
</html>