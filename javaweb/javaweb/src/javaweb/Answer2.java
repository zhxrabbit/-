package javaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import javaweb.DBUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javaweb.User;

/**
 * Servlet implementation class Answer2
 */
@WebServlet("/Answer2")
public class Answer2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Answer2() {
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
		String s[]={"cd","abcd"};
		String result="";
		int n=0;
		for(int i=0;i<s.length;i++){
			String answer2[]=request.getParameterValues("r"+i);
			String str="";
			for(int j=0;j<answer2.length;j++){
				str+=answer2[j];
			}
			result+=str;
			if(str.equals(s[i])){
				n++;
			}
		}
		System.out.println("answer2==="+result);
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		try{
			Connection con=DBUtil.getConnection();
			if(con==null)
				System.out.println("数据库未连接");
			String strSQL="update grade set double_answer='"+result+"',double_grade='"+n+"'where user='"+u.getUser()+"'";
			Statement pstm = con.createStatement();
			System.out.println("strSQL="+strSQL);
			pstm.executeUpdate(strSQL);
			pstm.close();			
			con.close();
			out.print("多选答题完成！");
			out.print("<a href='query.jsp'>查看成绩</a>");
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}

}
