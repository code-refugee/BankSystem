package com.bank.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.loginbean.*;
/*对client表进行操作*/
public class UseDao implements IUserDao{
	BaseDao bd=new BaseDao();
	public ResultSet r=null;
	//验证登录是否能成功
	public boolean findLogin(Client c) {
		boolean flg=false;
		String sql="select usename from client where useid='"+c.getUseId()+"' and password='"+c.getPassWd()+"'";
		try {
			if(bd.select(sql).next()){
				c.setUseName(bd.rs.getString(1));
				flg=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bd.getClose();
		return flg;
		
	}
	
	//密码是否更改成功
	public boolean updatePw(Client c){
		String sql="update client set password='"+c.getPassWd()+"' where useid='"+c.getUseId()+"'";
		int count=bd.update(sql);
		if(count==-1){
			bd.getClose();
			return false;
		}
		else{
			bd.getClose();
			return true;
		}
		
	}
	
	//创建一个新的用户名
	public String createNewId(){
		String sql="select * from client";
		r=bd.select(sql);
		int h=(int)((Math.random()*9+1)*100000);
		String s=null;
		s=String.valueOf(h);
		try {
			while(r.next()){
				String s1=r.getString("useid").toString();
				if(s1.equals(s)){
					h=(int)((Math.random()*9+1)*100000);
					s=String.valueOf(h);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		return s;
	}
	
	//添加一个新用户
	public void addClient(Client c){
		String sql="insert into client values('"+c.getUseId()+"','"+c.getUseName()+"','"+c.getPassWd()+"')";
		bd.insert(sql);
	}

}
