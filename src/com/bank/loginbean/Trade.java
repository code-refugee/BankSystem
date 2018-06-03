package com.bank.loginbean;

public class Trade {
	private String fromcardid;
	private String tocardid;
	private String tradetime;
	private String useid;
	private float trademoney;
	public String getFormCardId(){
		return fromcardid;
	}
	public String getToCardId(){
		return tocardid;
	}
	public String grtTradeTime(){
		return tradetime;
	}
	public String getUseId(){
		return useid;
	}
	public float getTradeMoney(){
		return trademoney;
	}
	public void setFormCardId(String fromcardid){
		this.fromcardid=fromcardid;
	}
	public void setToCardId(String tocardid){
		this.tocardid=tocardid;
	}
	public void setTradeTime(String tradetime){
		this.tradetime=tradetime;
	}
	public void setUseId(String useid){
		this.useid=useid;
	}
	public void setTradeMoney(float trademoney){
		this.trademoney=trademoney;
	}
	

}
