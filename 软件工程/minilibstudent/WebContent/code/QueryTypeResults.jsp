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
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="0" cellspacing="1" cellpadding="0" class="">
	<tr bgcolor="#fba661" height="25">
	  <td width="50%" bgcolor= "#ff95ca">
		<div align="center">
			图书分类编号
		</div>
	  </td>
	  <td width="50%" bgcolor= "#a6ffff">
		<div align="center">
			图书分类名称
		</div>
	  </td>
	</tr>

<%
	  List list=(List)request.getAttribute("CodeTypeList");
	  Iterator its=list.iterator();//迭代器，提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
	  while(its.hasNext()){
		  CodeBookType t=new CodeBookType();
		  t=(CodeBookType)its.next();
	%>
    <tr bgcolor="#f3f3f3" height="25">
      <td width="8%" >
        <div align="center">
          <%=t.getCodeId()%>
        </div>
      </td>
      <td width="8%" >
        <div align="center">
          <%=t.getCodeName()%>
        </div>
      </td>
    </tr>
    <%
      } 
    %>			
    </table>

</body>
</html>