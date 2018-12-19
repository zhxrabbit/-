<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人成绩页面</title>
</head>
<body background="photo/3.jpg">
<%
	int single_grade=(Integer)session.getAttribute("single_grade");
	int double_grade=(Integer)session.getAttribute("double_grade");
	int sum=single_grade+double_grade;
%>
<table  width="100%" border="0" cellspacing="1" cellpadding="0" class="">
	<tr bgcolor="#fba661" height="25">
	  <td width="15%" bgcolor= "#a0a0a0">
		<div align="center">
			单选成绩
		</div>
	  </td>
	  <td width="15%" bgcolor= "#a0a0a0">
		<div align="center">
			多选成绩
		</div>
	  </td>
	  <td width="18%" bgcolor="#a0a0a0">
		<div align="center">
			总成绩
		</div>
	  </td>
	</tr>		 
    <tr bgcolor="#f3f3f3" height="25">
      <td width="15%" >
        <div align="center">
          <%=single_grade%>
        </div>
      </td>
      <td width="15%" >
        <div align="center">
          <%=double_grade%>
        </div>
      </td>
      <td width="18%">
        <div align="center">
          <%=sum%>
        </div>
      </td>
    </tr>
</table>

</body>
</html>