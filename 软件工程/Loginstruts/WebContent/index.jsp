<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body background="3.jpg">
<table>
<form action="LoginAction.action" method="post" name="form1">
<tr><td>请输入姓名：</td><td><input align="middle" text" name="username"></input></td></tr>

<tr><td>用户密码：</td><td><input align="middle" type="password" name="userpass"></input></td></tr>
<tr><td></td>
<td><input type="submit" value="提交" name="submit"></input>
<input type="reset" value="重置" name="reset"></input></td></tr>
</form>
</table>

</body>
</html>