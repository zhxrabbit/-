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
<title>查询借阅结果页面</title>
</head>
<body background="../photo/3.jpg">
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
	<tr bgcolor="#fba661" height="25">
	  <td width="10%" bgcolor= "#ff95ca">
		<div align="center">
			编号
		</div>
	  </td>
	  <td width="10%" bgcolor= "#a6ffff">
		<div align="center">
			用户编号
		</div>
	  </td>
	  <td width="10%" bgcolor="#ff95ca">
		<div align="center">
			图书编号
		</div>
	  </td>
	  <td width="10%" bgcolor="#a6ffff">
		<div align="center">
			借书日期
		</div>
	  </td>
	  <td width="10%" bgcolor="#ff95ca">
		<div align="center">
			还书日期
		</div>
	  </td>
	  <td width="10%" bgcolor="#a6ffff">
		<div align="center">
			续借次数
		</div>
	  </td>
	</tr>
		 
	<%
	  List list=(List)request.getAttribute("BrowseList");
	  Iterator its=list.iterator();//迭代器，提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
	  while(its.hasNext()){
		  Record r=new Record();
		  r=(Record)its.next();
	%>
    <tr bgcolor="#f3f3f3" height="25">
      <td width="10%" >
        <div align="center">
          <%=r.getId()%>
        </div>
      </td>
      <td width="10%" >
        <div align="center">
          <%=r.getUserid()%>
        </div>
      </td>
      <td width="10%">
        <div align="center">
          <%=r.getBookid()%>
        </div>
      </td>
      <td width="10%" >
        <div align="center">
          <%=r.getBorrowdate()%>
        </div>
      </td>
      <td width="10%">
        <div align="center">
          <%=r.getReturndate()%>
        </div>
      </td>
      <td width="10%">
        <div align="center">
          <%=r.getRenewtimes()%>
        </div>
      </td>
    </tr>
    <%
      } 
    %>
	
</table>

</body>
</html>