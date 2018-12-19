<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册账户</title>
<style>
        .a{width: 200px;}
        #b{
            width: 500px;
            text-align: right;        /*右对齐*/·
        }
</style>
</head>
<body background="photo/3.jpg">
<div id="b">
<form action="Regist" method="post">
用户名:<input type="text" class="a" name="user"><br>
密码:<input type="text" class="a" name="pwd"><br>
真实姓名:<input type="text" class="a" name="realname"><br>
年龄:<input type="text" class="a" name="age"><br>
学号:<input type="text" class="a" name="studno"><br>
<input type="submit" class="a" value="注册账号">
</form>
</div>
</body>
</html>