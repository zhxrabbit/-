package minilib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.CodeBookType;
import minilib.vo.Title;

import com.mysql.jdbc.Statement;

public class ManageTitlesDao {
	
	public List findBookType() throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		Statement stmt=(Statement) conn.createStatement();
		String strsql="select codeid,codename from code_booktype order by codeid";
		System.out.print("strsql="+strsql);
		ResultSet rs=stmt.executeQuery(strsql);//结果集
		while(rs.next()){
			CodeBookType booktype=new CodeBookType();
			booktype.setCodeId(rs.getString(1));
			booktype.setCodeName(rs.getString(2));
			list.add(booktype);
		}
		rs.close();
		stmt.close();
		conn.close();
		return list;
	}
	
	public void addTitle(Title book) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();	
		if(conn==null)
			System.out.println("数据库未连接");
		String sql="insert into t_book(isbn,title,authors) values('"+book.getIsbn()+"','"+book.getTitle()+"','"+book.getAuthors()+"')";
		Statement stmt=(Statement) conn.createStatement();//创建了一个对象然后去通过对象调用executeQuery方法来执行sql语句
		stmt.execute(sql);
		stmt.close();
	}
	
	public List findTitles(String titles) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		try{
			//建立数据库连接
			Connection conn=DBUtil.getConnection();
			if(conn==null)
				System.out.println("数据库未连接");
			//定义查询语句
			String sql="select * from t_book where title like '%"+titles+"%'";
			System.out.println("sql="+sql);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//获取查询结果集
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Title title=new Title();
				title.setTypeid(rs.getString(2));
				title.setIsbn(rs.getString(3));
				title.setTitle(rs.getString(5));
				title.setAuthors(rs.getString(6));
				title.setPressid(rs.getString(8));
				list.add(title);
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
	
	public void deleteTitle(String title) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		//删除语句
		String sql ="delete from t_book where title ='"+title+"'";
		Statement stmt=(Statement) conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
	
}
