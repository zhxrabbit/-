package javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javaweb.DBUtil;
import javaweb.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String login=request.getParameter("login");
		String login1=new String(login.getBytes("ISO-8859-1"),"UTF-8");
		PrintWriter out=response.getWriter();//输出页面
		if(login1.equals("登录账号")){
			String user=request.getParameter("user");
			String pwd=request.getParameter("pwd");
			boolean mark = true;
			try{
				Connection con=DBUtil.getConnection();
				if(con==null)
					System.out.println("数据库未连接");
				String strSQL = "select * from user where user=? and pwd=?";
				PreparedStatement pstm = con.prepareStatement(strSQL);
				System.out.println("strSQL="+strSQL);
				pstm.setString(1, user);
				pstm.setString(2, pwd);
				ResultSet rst = pstm.executeQuery();//跟数据库某一张具体的表产生交互，并获得其中的数据，获得该数据的结果集
				if(rst.next()){
					String name = rst.getString("realname");
					String age = rst.getString("age");
					String studno = rst.getString("studno");					
					User u = new User();
					u.setUser(user); 
					u.setPwd(pwd); 
					u.setAge(age);
					u.setRealName(name); 
					u.setStudno(studno);
					HttpSession session = request.getSession();
					session.setAttribute("user",u);
				}
				else{
					mark=false;
				}		
				pstm.close();
				con.close();				
				if(mark==true)
					response.sendRedirect("main.jsp");
				else
				{
					out.print("没有注册账号！"+"<br>");
					out.print("<a href='login.jsp'>注册账号</a>");
				}	
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			response.sendRedirect("regist.jsp");//地址栏会改变，request作用域丢失
		}
	}
}
