package minilib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.CodeBookType;

import com.mysql.jdbc.Statement;

public class ManageCodeDao {
	public List findBookCodePress() throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		Statement stmt=(Statement) conn.createStatement();
		String strsql="select codeid,codename from code_press order by codeid";
		System.out.print("strsql="+strsql);
		ResultSet rs=stmt.executeQuery(strsql);
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
	
	public void addCodePress(CodeBookType code) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		String sql="insert into code_press(codeId,codeName) values('"+code.getCodeId()+"','"+code.getCodeName()+"')";
		Statement stmt=(Statement) conn.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
	
	public List findCodePress(String codepress) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		try{
			//建立数据库连接
			Connection conn=DBUtil.getConnection();
			if(conn==null)
				System.out.println("数据库未连接");
			//定义查询语句
			String sql="select codeid,codename from code_press where codeName like '%"+codepress+"%'";
			System.out.println("sql="+sql);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//获取查询结果集
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				CodeBookType booktype=new CodeBookType();
				booktype.setCodeId(rs.getString(1));
				booktype.setCodeName(rs.getString(2));
				list.add(booktype);
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
	
	public void deletePress(String code) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		String sql ="delete from code_press where codeName ='"+code+"'";
		Statement stmt=(Statement) conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
	
	public List findBookCodeType() throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		Statement stmt=(Statement) conn.createStatement();
		String strsql="select codeid,codename from code_booktype order by codeid";
		System.out.print("strsql="+strsql);
		ResultSet rs=stmt.executeQuery(strsql);
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
	
	public void addCodeType(CodeBookType code) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		String sql="insert into code_booktype(codeId,codeName) values('"+code.getCodeId()+"','"+code.getCodeName()+"')";
		Statement stmt=(Statement) conn.createStatement();
		stmt.execute(sql);
		stmt.close();
	}
	
	public List findCodeType(String codetype) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		try{
			//建立数据库连接
			Connection conn=DBUtil.getConnection();
			if(conn==null)
				System.out.println("数据库未连接");
			//定义查询语句
			String sql="select codeid,codename from code_booktype where codeName like '%"+codetype+"%'";
			System.out.println("sql="+sql);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//获取查询结果集
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				CodeBookType booktype=new CodeBookType();
				booktype.setCodeId(rs.getString(1));
				booktype.setCodeName(rs.getString(2));
				list.add(booktype);
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
	
	public void deleteType(String code) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		Connection conn=DBUtil.getConnection();
		if(conn==null)
			System.out.println("数据库未连接");
		String sql ="delete from code_booktype where codeName ='"+code+"'";
		Statement stmt=(Statement) conn.createStatement();
		stmt.executeUpdate(sql);
		stmt.close();
		conn.close();
	}
}
