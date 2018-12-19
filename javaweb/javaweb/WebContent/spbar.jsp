<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<style type="text/css">
  .point {
  	font-size: 10px; 
  	cursor: pointer; 
  	color: #000000; 
  	font-family: "宋体"; 
  	position: absolute; 
  	background-color: #7B8D91;
  }
  .spline1{
  	background-color: #7B8D91;
  }
  .spBgColor{
  	cursor: pointer; 
  	background-color: #7B8D91;
  }
	</style>
	<script language="javascript">
	//
	function changeWin(evt){
		evt = evt ? evt:(window.event?window.event:null);
		if(window.top.document.getElementById("forum").cols != "8,*"){
			window.top.document.getElementById("forum").cols = "8,*";
			document.getElementById("menuSwitch").innerHTML = "<font class=point>&gt;&gt;</font>";
		}else{
			window.top.document.getElementById("forum").cols = "200,*";
			document.getElementById("menuSwitch").innerHTML = "<font class=point>&lt;&lt;</font>";
		}
	}
</script>
</head>
<body>
<table height="100%" cellSpacing="0" cellPadding="0" width="100%" border="0">
    <tbody><tr>
      <td width="100%">
        <iframe id="trview" name="trview" style="visibility:inherit; width:100%; height:100%" src="menu.jsp"  frameborder="0"   marginwidth="0"></iframe>
      </td><td class="spline1"><img height="1" width="1"></td>
      <td class="spBgColor">
    	<table height="100%" cellSpacing="0" cellPadding="0" width="100%" border="0">
    	<tbody><tr><td onclick="changeWin(event);" height="1">
          <img height="1" width="8"></td></tr><tr>
    		<td id="menuSwitch" onclick="changeWin(event);" height="100%">
    		<font class="point">&lt;&lt;</font></td></tr>
    	</tbody></table>
      </td></tr>
    </tbody>
  </table>

</body>
</html>