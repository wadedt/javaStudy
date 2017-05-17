package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oop.DBUtility;

public class ProductDAO {
	public static void main(String[] args){
		ProductDAO dao = new ProductDAO();
		dao.findAll();
	}
	public void findAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtility.openConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from vmc_b2c_goods");
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		}catch(SQLException e){
			System.out.println("数据库连接异常");
			throw new RuntimeException(e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				};
				if(stmt!=null){
					stmt.close();
				};
			}catch(Exception e){
				System.out.println("数据库关闭出现异常");
			}
			DBUtility.closeConnection(conn);
		}
	}
}
