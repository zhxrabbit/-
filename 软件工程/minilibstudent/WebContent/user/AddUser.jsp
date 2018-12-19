<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加用户页面</title>
</head>
<body background="../photo/3.jpg">
${message}
<form method="post" action="addUserManageUserAction.action">

用户列表
<select name="">
	<c:forEach items="${requestScope.allUserList}" var="bookuser" varStatus="status">
	<option value="${bookuser.userid}">${bookuser.username}
	</c:forEach>
</select><br>

<table>
  <tr><td>用户编号：</td><td><input type="text" name="user.userid" value=""></td></tr>
  <tr><td>证件号码：</td><td><input type="text" name="user.idcard" value=""></td></tr>
  <tr><td>用户姓名：</td><td><input type="text" name="user.username" value=""></td></tr>
  <tr><td>性别编号：</td>
  <td><input type="text" name="user.sexid" value="">
<%-- 
  <select name="user.sexid">
	<c:forEach items="${requestScope.allUserList}" var="bookuser" varStatus="status">
	<option value="${bookuser.userid}">${bookuser.sexid}
	</c:forEach>
  </select> 
--%>
  </td></tr>
<!--    -->
  <tr><td>用户生日：</td><td><input type="text" name="user.birthday" value=""></td></tr>
  <tr><td>单位编号：</td><td><input type="text" name="user.deptid" value=""></td></tr>
  <tr><td>用户类型：</td><td><input type="text" name="user.typeid" value=""></td></tr>
  <tr><td>账户密码：</td><td><input type="text" name="user.password" value=""></td></tr>
  <tr><td><input type="submit" name = "sumbit" value = "增加用户"></td></tr>
</table>
</form>

</body>
</html>