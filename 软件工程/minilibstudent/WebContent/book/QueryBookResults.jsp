<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.util.*"
	import = "minilib.vo.*"
	import = "minilib.dao.*" 
	import = "minilib.util.*" 
	import = "minilib.action.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询用户结果</title>
</head>
<body>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
	<tr bgcolor="#fba661" height="25">
	  <td width="8%" bgcolor= "#ff95ca">
		<div align="center">
			分类
		</div>
	  </td>
	  <td width="8%" bgcolor= "#a6ffff">
		<div align="center">
			ISBN
		</div>
	  </td>
	  <td width="11%" bgcolor="#ff95ca">
		<div align="center">
			书名
		</div>
	  </td>
	  <td width="10%" bgcolor="#a6ffff">
		<div align="center">
			作者
		</div>
	  </td>
	  <td width="11%" bgcolor="#ff95ca">
		<div align="center">
			出版社
		</div>
	  </td>
	</tr>
		 
	<%
	  List list=(List)request.getAttribute("TitlesList");
	  Iterator its=list.iterator();//迭代器，提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
	  while(its.hasNext()){
		  Title t=new Title();
		  t=(Title)its.next();
	%>
    <tr bgcolor="#f3f3f3" height="25">
      <td width="8%" >
        <div align="center">
          <%=t.getTypeid()%>
        </div>
      </td>
      <td width="8%" >
        <div align="center">
          <%=t.getIsbn()%>
        </div>
      </td>
      <td width="11%">
        <div align="center">
          <%=t.getTitle()%>
        </div>
      </td>
      <td width="10%" >
        <div align="center">
          <%=t.getAuthors()%>
        </div>
      </td>
      <td width="11%">
        <div align="center">
          <%=t.getPressid()%>
        </div>
      </td>
    </tr>
    <%
      } 
    %>
	
</table>

</body>
</html>