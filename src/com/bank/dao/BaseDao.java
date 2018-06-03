package com.bank.dao;

import java.sql.*;
/*该类是连接数据库类*/
public class BaseDao {
	private Connection con=null;
	private PreparedStatement psm=null;
	public ResultSet rs=null;
	private void getCon(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/bank";
			String user="root";
			String pass="12345";
			con=DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询操作
	public ResultSet select(String sql){
		getCon();
		try {
			psm=con.prepareStatement(sql);
			rs=psm.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//更新操作
	public int update(String sql){
		getCon();
		try {
			psm=con.prepareStatement(sql);
			int count=psm.executeUpdate();
			return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	/*插入操作*/
	public void insert(String sql){
		getCon();
		try {
			psm=con.prepareStatement(sql);
			psm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//关闭连接
	public void getClose(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(psm!=null){
				psm.close();
			}
			if(con!=null){
				con.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
