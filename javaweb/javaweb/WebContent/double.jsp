<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多选</title>
</head>
<body background="photo/3.jpg">
<FONT size=4>
   <FORM action="Answer2"method=post name=form>
     <P>我国四大古典小说: <BR>
     <INPUT type="checkbox" name="r0" value="a">《武林外传》
     <INPUT type="checkbox" name="r0" value="b">《西厢记》
     <INPUT type="checkbox" name="r0" value="c">《红楼梦》
     <INPUT type="checkbox" name="r0" value="d">《西游记》 
     <P>四大名绣: <BR>
     <INPUT type="checkbox" name="r1" value="a">苏绣
     <INPUT type="checkbox" name="r1" value="b">湘绣
     <INPUT type="checkbox" name="r1" value="c">粤绣
     <INPUT type="checkbox" name="r1" value="d">蜀绣<!--  checked="ok" -->
     <BR>
     <br>     
     <INPUT TYPE="submit" value="提交答案" name="submit">
  </FORM>
</FONT>

</body>
</html>