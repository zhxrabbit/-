package javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javaweb.Grade;
import javaweb.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Query
 */
@WebServlet("/Query")
public class Query extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Query() {
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
		String studno=request.getParameter("studno");
		PrintWriter out=response.getWriter();
		String query=request.getParameter("query");
		String query1=new String(query.getBytes("ISO-8859-1"),"UTF-8");
		try{
			if(query1.equals("个人查询")){
			String strSQL = "select * from grade where studno = ?";
			Connection con = DBUtil.getConnection();
			if(con==null){
				System.out.println("数据库未连接");
				out.println("个人查询失败！<a href='main.jsp'>重新查询</a>");
			}
			PreparedStatement pstm = con.prepareStatement(strSQL);
			System.out.println("sql="+strSQL);
			pstm.setString(1, studno);
			ResultSet rst = pstm.executeQuery();
			while(rst.next()){
				int single_grade=rst.getInt("single_grade");
				int double_grade=rst.getInt("double_grade");
				HttpSession session=request.getSession();
				session.setAttribute("single_grade", single_grade);
				session.setAttribute("double_grade", double_grade);
			}
			pstm.close();
			con.close();
			response.sendRedirect("grade1.jsp");
			}
			else
				if(query1.equals("模糊查询")){
					String strSQL = "select * from grade";
					Connection con =DBUtil.getConnection();
					if(con==null){
						System.out.println("数据库未连接");
						out.println("模糊查询失败!<a href='main.jsp'>重新查询</a>");
					}
					PreparedStatement pstm = con.prepareStatement(strSQL);
					System.out.println("strSQL==="+strSQL);
					ResultSet rst = pstm.executeQuery();
					List list=new ArrayList();
					while(rst.next()){
						Grade grade=new Grade();
						grade.setUser(rst.getString(1));
						grade.setStudno(rst.getString(2));
						grade.setRealName(rst.getString(3));
						grade.setSingle_grade(rst.getInt(6));
						grade.setDouble_grade(rst.getInt(7));
						list.add(grade);
						HttpSession session=request.getSession();
						session.setAttribute("gradelist", list);
						}
					pstm.close();
					con.close();
					response.sendRedirect("grade2.jsp");
				}
				else
					if(query1.equals("结束考试"))
						out.println("考试已结束！");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
