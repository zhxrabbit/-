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
<html><head><title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script language="JavaScript" type="text/JavaScript">
  	function showMenu(id){
  		var menu = "menu_" + id;
  		var item=document.getElementById(menu);
  		for(i=1;i<=6;i++){
  			document.getElementById("menu_0" + i).style.display="none";
  		}
  		item.style.display = "block";
  	}
  </script>

</head>

<body>
  
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td onClick="showMenu('01');" align="center">图书管理</td>
  </tr></table>
  <table border="1" id="menu_01" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a align="center" href="findBookTypeManageTitlesAction.action" target="main" title="增加图书">增加图书</a></td></tr>
    <tr><td align="center"><a align="center" href="../book/QueryBook.jsp" target="main" title="查询图书">查询图书</a></td></tr>
    <tr><td align="center"><a align="center" href="../book/DeleteBook.jsp" target="main" title="删除图书">删除图书</a></td></tr>
  </table>
  
  <!-- -->
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td  onClick="showMenu('02');" align="center">书目管理</td>
  </tr></table>
  <table border="1" id="menu_02" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a href="findBookCodePressManageCodeAction.action" target="main" title="增加出版社">增加出版社</a></td></tr>
    <tr><td align="center"><a href="../code/QueryPress.jsp" target="main" title="查询出版社">查询出版社</a></td></tr>
    <tr><td align="center"><a href="../code/DeletePress.jsp" target="main" title="删除出版社">删除出版社</a></td></tr>
    <tr><td align="center"><a href="findBookCodeTypeManageCodeAction.action" target="main" title="增加图书分类">增加图书分类</a></td></tr>
    <tr><td align="center"><a href="../code/QueryType.jsp" target="main" title="查询图书分类">查询图书分类</a></td></tr>
    <tr><td align="center"><a href="../code/DeleteType.jsp" target="main" title="删除图书分类">删除图书分类</a></td></tr>
  </table>

  <!--  -->
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td onClick="showMenu('03');" align="center">借阅管理</td>
  </tr></table>
  <table border="1" id="menu_03" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a href="../main/wait.jsp" target="main" title="添加借书">添加借书</a></td></tr>
    <tr><td align="center"><a href="../core/QueryBrowse.jsp" target="main" title="查询借书">查询借书</a></td></tr>
  </table>
  
  <!--  --> 
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td  onClick="showMenu('04');" align="center">领导功能</td>
  </tr></table>
  <table border="1" id="menu_04" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a href="../main/wait.jsp" target="main" title="#">领导功能</a></td></tr>
  </table>

  <!--   -->
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td onClick="showMenu('05');" align="center">读者功能</td>
  </tr></table>
  <table border="1" id="menu_05" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a href="../main/wait.jsp" target="main" title="#">读者功能</a></td></tr>
  </table>
 
 
  <!-- -->
  <table border="1" bgcolor="#a0a0a0" width="100%"><tr>
  <td  onClick="showMenu('06');" align="center">用户管理</td>
  </tr></table>
  <table border="1" id="menu_06" style="display:none;" bgcolor="#f0f0f0" width="100%">
    <tr><td align="center"><a href="findBookUserManageUserAction.action" target="main" title="增加用户">增加用户</a></td></tr>
    <tr><td align="center"><a href="../user/QueryUser.jsp" target="main" title="查询用户">查询用户</a></td></tr>
  </table>

</body>

</html>
