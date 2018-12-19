<%@ page language="java" contentType="text/html; charset=UTF-8"
    import ="javaweb.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成绩查询页面</title>
<style>
        .a{width: 200px;}
        #b{
            width: 300px;
            text-align: right;        /*右对齐*/·
        }
</style>
</head>
<body background="photo/3.jpg">
<div id="b">
<form action="Query">
    学生证号:<input type="text" class="a" name="studno"><br>
  <input type="submit" style="width:100px" name="query" value="个人查询">
  <input type="submit" style="width:100px" name="query" value="模糊查询"><br>
  <input type="submit" style="width:200px" name="query" value="结束考试"><br>
</form>
</div>

</body>
</html>