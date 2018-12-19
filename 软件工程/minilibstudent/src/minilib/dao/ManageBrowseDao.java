package minilib.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minilib.util.DBUtil;
import minilib.vo.Record;

public class ManageBrowseDao {/**/
	public List findBrowse(String userid,String bookid) throws InstantiationException,IllegalAccessException,ClassNotFoundException,SQLException{
		List list=new ArrayList();
		try{
			//建立数据库连接
			Connection conn=DBUtil.getConnection();
			if(conn==null)
				System.out.println("数据库未连接");
			//定义查询语句
			String sql="select * from t_record where userid like '%"+userid+"%' or bookid like '%"+bookid+"%'";/**/
			System.out.println("sql="+sql);
			PreparedStatement pstmt=conn.prepareStatement(sql);
			//获取查询结果集
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				Record record=new Record();
				record.setId(rs.getString(1));
				record.setUserid(rs.getString(2));
				record.setBookid(rs.getString(3));
				record.setBorrowdate(rs.getString(4));
				record.setReturndate(rs.getString(5));
				record.setRenewtimes(rs.getString(6));
				list.add(record);
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
