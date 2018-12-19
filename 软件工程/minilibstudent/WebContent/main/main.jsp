<!-- 
/***********************************************************
*                         
*                           
* 项目名称：          
* 子系统名：     
* 功能名称： 
* 完成人员：         
* 完成时间：         
*               
*                 
************************************************************/
-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title></title>
</head>

<frameset id="fbody" rows="50,*" frameborder="no" border="0" framespacing="0">	
	<frame id="top" name="top" src="top.jsp"  scrolling="no" noresize frameborder="0" marginheight="0" marginwidth="0">	
	<frameset id="forum" cols="200,*" framespacing="0" frameborder="no" border="0" rows="*">	
		<frame id="menu" name="menu" src="spbar.jsp" scrolling="no" frameborder="0" marginheight="0" marginwidth="0">	
		<frameset id="content" rows="*,40" framespacing="0" frameborder="no" border="0" cols="*">	
			<frame id="main" name="main" src="welcome.jsp">	
			<frame id="bottom" name="bottom" src="foot.jsp" frameborder="0" marginheight="0" scrolling="no" marginwidth="0">	
		</frameset>
	</frameset>
</frameset>
<noframes>
	<body>
	</body>
</noframes>

</html>