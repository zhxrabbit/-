<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="javaweb.*"
    import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>模糊成绩页面</title>
</head>
<body background="photo/3.jpg">
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
	<tr bgcolor="#fba661" height="25">
	  <td width="12%" bgcolor= "#a0a0a0">
		<div align="center">
			用户名
		</div>
	  </td>
	  <td width="12%" bgcolor= "#a0a0a0">
		<div align="center">
			学号
		</div>
	  </td>
	  <td width="12%" bgcolor="#a0a0a0">
		<div align="center">
			姓名
		</div>
	  </td>
	  <td width="12%" bgcolor="#a0a0a0">
		<div align="center">
			总成绩
		</div>
	  </td>
	</tr>		 
	<%
	  List list=(List)session.getAttribute("gradelist");
	  Iterator its=list.iterator();//迭代器，提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
	  while(its.hasNext()){
		  Grade g=new Grade();
		  g=(Grade)its.next();
		  int sum=g.getSingle_grade()+g.getDouble_grade();
	%>
    <tr bgcolor="#f3f3f3" height="25">
      <td width="12%" >
        <div align="center">
          <%=g.getUser()%>
        </div>
      </td>
      <td width="12%" >
        <div align="center">
          <%=g.getStudno()%>
        </div>
      </td>
      <td width="12%">
        <div align="center">
          <%=g.getRealName()%>
        </div>
      </td>
      <td width="12%">
        <div align="center">
          <%=sum%>
        </div>
      </td>
    </tr>
    <%
      } 
    %>	
</table>

</body>
</html>