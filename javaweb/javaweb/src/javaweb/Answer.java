package javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javaweb.DBUtil;
import javaweb.User;

/**
 * Servlet implementation class Answer
 */
@WebServlet("/Answer")
public class Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer() {
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
		PrintWriter out=response.getWriter();
		String s[]={"a","b"};
		String result="";
		int n=0;
		for(int i=0;i<s.length;i++){
			String answer=request.getParameter("r"+i);
			result+=answer;
			if(answer.equals(s[i])){
				n++;
			}
		}
		System.out.println("answer==="+result);
		String strSQL="insert into grade values(?,?,?,?,?,?,?)";
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		try{
			Connection con=DBUtil.getConnection();
			if(con==null){
				System.out.println("数据库未连接");
/*				throw Connection con;*/
			}
			PreparedStatement pstm = con.prepareStatement(strSQL);
			System.out.println("strSQL="+strSQL);
			pstm.setString(1, u.getUser());
			pstm.setString(2, u.getStudno());
			pstm.setString(3, u.getRealName());
			pstm.setString(4, result);
			pstm.setString(5,"null");
			pstm.setInt(6,n);
			pstm.setInt(7,0);
			pstm.executeUpdate();
			pstm.close();			
			con.close();
			System.out.println(u.getRealName());
			out.print("单选答题完成！");
			out.print("<a href='double.jsp'>继续考试</a>");
		}
		catch(Exception e){
			e.printStackTrace();
			strSQL="update grade set single_answer='"+result+"',single_grade='"+n+"'where user='"+u.getUser()+"'";
			System.out.println("strSQL="+strSQL);
/*			service(strSQL);*/
			}
	}

}
