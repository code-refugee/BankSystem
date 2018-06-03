package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.bank.loginbean.*;

public class UseCard {
	BaseDao bd=new BaseDao();
	public ResultSet r=null;
	public ResultSet r1=null;
	public List<String> list=new ArrayList<String>();
	
	/*将查到的交易信息以集合形式返回*/
	public List findHistory(Client c){
		String sql="select * from trade where useid='"+c.getUseId()+"'";
		String s=null;
		String s2=null;
		r=bd.select(sql);
		try {
			while(r.next()){
				list.add(r.getString("fromcardid").toString());
				list.add(r.getString("tocardid").toString());
				s="select useid from card where cardid='"+r.getString("tocardid").toString()+"'";
				r1=bd.select(s);
				while(r1.next()){
					s2="select usename from client where useid='"+r1.getString("useid").toString()+"'";
				}
				r1=bd.select(s2);
				while(r1.next()){
					list.add(r1.getString("usename").toString());
				}
				list.add(r.getString("trademoney").toString());
				list.add(r.getString("tradetime").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		return list;
	}
	/*将查到的用户银行卡信息以集合形式返回*/
	public List findCard(Client c){
		String sql="select * from card where useid='"+c.getUseId()+"'";
		r=bd.select(sql);
		try {
			while(r.next()){
				list.add(r.getString("useid").toString());
				list.add(r.getString("cardid").toString());
				list.add(r.getString("money").toString());
				list.add(r.getString("cardcreatetime").toString());
			}
			bd.getClose();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return list;

		
	}
	
	/*检查银行卡密码是否正确*/
	public boolean Islegal(Card ca,String ps){
		String sql="select cardps from card where cardid='"+ca.getCardId()+"'";
		boolean flg=false;
		r=bd.select(sql);
		try {
			while(r.next()){
				if(ps.equals(r.getString("cardps").toString())){
					flg=true;
				}else{
					flg=false;
				}
			}
			return flg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			bd.getClose();
		}
		
	}
	/*检查银行卡内余额是否够*/
	public boolean isEnough(Card ca,float f){
		String sql="select money from card where cardid='"+ca.getCardId()+"'";
		r=bd.select(sql);
		float sf=0;
		boolean flg=false;
		try {
			while(r.next()){
				sf=Float.parseFloat(r.getString("money").toString());
			}
			if(sf<f){
				flg=false;
			}
			else{
				flg=true;
			}
			return flg;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			bd.getClose();
		}
	}
	
	/*存款操作*/
	public boolean inCreaseMoney(Card ca){
		String sql1="select money from card where cardid='"+ca.getCardId()+"'";
		r=bd.select(sql1);
		float f1 = 0 ;
		int i=0;
		boolean flg=false;
		try {
			while(r.next()){
				float f=Float.parseFloat(r.getString("money").toString());
				f1=f+ca.getMoney();
			}
			String sql2="update card set money="+f1+"where cardid='"+ca.getCardId()+"'";
			 i=bd.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		if(i==-1){
			flg=false;
		}
		else{
			flg=true;
		}
		return flg;
	}
	
	/*取款操作*/
	public boolean deCreaseMoney(Card ca,float f){
		String sql1="select money from card where cardid='"+ca.getCardId()+"'";
		r=bd.select(sql1);
		float f1 = 0 ;
		int i=0;
		boolean flg=false;
		try {
			while(r.next()){
				float df=Float.parseFloat(r.getString("money").toString());
				f1=df-f;
			}
			String sql2="update card set money="+f1+"where cardid='"+ca.getCardId()+"'";
			 i=bd.update(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		if(i==-1){
			flg=false;
		}
		else{
			flg=true;
		}
		return flg;
	}
	
	/*检查银行卡号是否存在*/
	public boolean existsCardId(Card ca){
		String sql="select * from card where cardid='"+ca.getCardId()+"'";
		boolean flg=false;
		r=bd.select(sql);
		try {
			while(r.next()){
				flg=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		return flg;
		
	}
	
	/*检查银行卡和用户名是否对上*/
	public boolean isUse(Card ca,String cname){
		String s1=null;
		String s=null;
		boolean flg=false;
		String sql1="select useid from card where cardid='"+ca.getCardId()+"'";
		r=bd.select(sql1);
		try {
			while(r.next()){
				s1=r.getString("useid").toString();
			}
			String sql2="select usename from client where useid='"+s1+"'";
			r1=bd.select(sql2);
			while(r1.next()){
				s=r1.getString("usename").toString();
			}
			if(s.equals(cname)){
				flg=true;
			}else{
				flg=false;
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			bd.getClose();
		}
		return flg;
	}
	
	/*添加交易记录*/
	public void addHistroy(Trade t){
		String sql="insert into trade(fromcardid,tocardid,tradetime,trademoney,useid)"
				+ "values('"+t.getFormCardId()+"','"+t.getToCardId()+"','"+t.grtTradeTime()
				+"',"+t.getTradeMoney()+",'"+t.getUseId()+"')";
		bd.insert(sql);
		bd.getClose();
	}

}
