<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>计算</title>
</head>
<body background="3.jpg">
<div align="center" >
<form action="Control" method="post">
  <input "text" name="num1" value=""></input>
    <select name="oper">
      <option value="+" selected>+</option>
      <option value="-" >-</option>
      <option value="*" >*</option>
      <option value="/" >/</option>
    </select>
  <input type="text" name="num2"></input>
  <input type="submit" value="="></input>${result }
</form>
</div>
</body>
</html>