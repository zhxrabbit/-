package minilib.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.*;

import minilib.vo.User;
import minilib.util.DBUtil;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String execute() throws Exception{
		boolean mark=true;
		Connection con=DBUtil.getConnection();
		if(con==null)
			System.out.println("数据库未连接");
		String strSQL = "select * from t_user where name=? and password=?";
		PreparedStatement pstm = con.prepareStatement(strSQL);
		System.out.println("strSQL="+strSQL);
		pstm.setString(1, user.getUsername());
		pstm.setString(2, user.getPassword());
		ResultSet rst = pstm.executeQuery();//跟数据库某一张具体的表产生交互，并获得其中的数据，获得该数据的结果集
		if(rst.next()){
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session=request.getSession();
			session.setAttribute("username", user.getUsername());
		}
		else{
			mark=false;
		}
		if(mark==true)
			return "success";
		else
			return "error";
	}
}
