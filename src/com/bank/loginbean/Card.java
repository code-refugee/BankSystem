package com.bank.loginbean;

public class Card {
	private String cardid;
	private String cardps;
	private String cardcreatetime;
	private float money;
	public String getCardId(){
		return cardid;
	}
	public void setCardId(String cardid){
		this.cardid=cardid;
	}
	public String getCardPs(){
		return cardps;
	}
	public void setCardPs(String cardps){
		this.cardps=cardps;
	}
	public String getCardCreateTime(){
		return cardcreatetime;
	}
	public void setCardCreateTime(String cardcreatetime){
		this.cardcreatetime=cardcreatetime;
	}
	public float getMoney(){
		return money;
	}
	public void setMoney(float money){
		this.money=money;
	}

}
