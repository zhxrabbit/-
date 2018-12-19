package javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		String realname=request.getParameter("realname");
		String age=request.getParameter("age");
		String studno=request.getParameter("studno");
		PrintWriter out=response.getWriter();
		try{			
			Connection con=DBUtil.getConnection();
			if(con==null)
				System.out.println("数据库未连接");
			String strSQL="insert into user values('"+user+"','"+pwd+"','"+realname+"','"+age+"','"+studno+"')" ;
			Statement stm=con.createStatement();
			stm.executeUpdate(strSQL);
			System.out.print("strSQL="+strSQL);
			stm.close();
			con.close();
			out.print("注册账号成功!"+"<br>");
			out.print("<a href='login.jsp'>登录账号</a>");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
