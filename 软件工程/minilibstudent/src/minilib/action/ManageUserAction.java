package minilib.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import minilib.vo.User;
import minilib.dao.ManageUserDao;

public class ManageUserAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String findBookUser() throws Exception{
		ManageUserDao mttype=new ManageUserDao();
		List allUserList=mttype.findBookUser();//返回放到一个列表里
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("allUserList", allUserList);
		System.out.println("findBookUser");
		return "bookuser";
	}
	public String addUser()throws Exception{
		ManageUserDao mtadd=new ManageUserDao();
		mtadd.addUser(user);  
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("message","添加成功请继续添加！");
		System.out.println("adduserTitles"+user.getUsername());
		return "adduser";
	}
	public String findUser()throws Exception{
		ManageUserDao mt=new ManageUserDao();
		List UserList=mt.findUser(user.getUsername());
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("UserList",UserList);//添加指定的属性并为其赋指定的值
		System.out.println("findUser");
		return "queryuser";
	} 

}
