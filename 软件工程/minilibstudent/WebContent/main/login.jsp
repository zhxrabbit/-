<!-- 
/***********************************************************
*													
*														
*	项目名称：				
*	子系统名：			
*	功能名称：	
*	完成人员：					
*	完成时间：					
*								
*									
************************************************************/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>小型图书资料管理系统登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style>
        .a{width: 200px;}
</style>
  </head>
  <body background="../photo/1.jpg">
	<form method="post" action="login.action" name="frm">
	<h1 align="center">
	<font color="#ffffff">小型图书资料管理系统-版本_0.1.0 2018年10月7日<br/><br/></h1>
	  <p align="center"> 
	    用户账户： <input type="text" class="a" name="user.username" value="周惠馨"><br/>
	    登录密码： <input type="password" class="a" name="user.password" value="123456"><br/><br/>
	  <input type="submit" style="width:100px" value="登录系统" name="login">
	  <input type="reset" style="width:100px" value="重新填写" name="reset"><br/><br/></p>
      <p align="center">Copyright@ 2009-2018 版权所有 辽宁师范大学</p></font>
	</form>
  </body>
</html>
