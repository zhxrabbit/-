package minilib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import minilib.util.DBUtil;
import minilib.vo.User;

public class ManageUserDao {
	public List findBookUser() throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		Statement stmt=(Statement) conn.createStatement();
		String strsql="select userid,name from t_user";
		System.out.println("strsql="+strsql);
		ResultSet rs=stmt.executeQuery(strsql);//结果集
		while(rs.next()){
			User user=new User();
			user.setUserid(rs.getString(1));
			user.setUsername(rs.getString(2));
			list.add(user);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	public void addUser(User user) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();	
		if(conn==null)
			System.out.println("数据库未连接");
		String sql="insert into t_user(userid,idcard,name,sexid,birthday,deptid,typeid,password) values('"+user.getUserid()+"','"+user.getIdcard()+"','"+user.getUsername()+"','"+user.getSexid()+"','"+user.getBirthday()+"','"+user.getDeptid()+"','"+user.getTypeid()+"','"+user.getPassword()+"')";
		Statement stmt=(Statement) conn.createStatement();//创建了一个对象然后去通过对象调用executeQuery方法来执行sql语句
		stmt.execute(sql);
		stmt.close();
	}/**/
	public List findUser(String username) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		try{
			//建立数据库连接
			Connection conn=DBUtil.getConnection();
			if(conn==null)
				System.out.println("数据库未连接");
			//定义查询语句
			String sql="select * from t_user where name like '%"+username+"%'";
			System.out.println("sql="+sql);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//获取查询结果集
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				User user=new User();
				user.setUserid(rs.getString(1));
				user.setIdcard(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setSexid(rs.getString(4));
				user.setBirthday(rs.getString(5));
				list.add(user);
			}
			rs.close();
			pstmt.close();
			conn.close();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

}
