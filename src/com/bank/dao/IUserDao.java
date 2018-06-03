package com.bank.dao;
import com.bank.loginbean.*;
/*自定义接口*/
public interface IUserDao {
	/*用户验证登录*/
	public boolean findLogin(Client c);

}
