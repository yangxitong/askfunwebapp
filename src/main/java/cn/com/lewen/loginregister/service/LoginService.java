package cn.com.lewen.loginregister.service;


public interface LoginService {
	
	/**
	 * 用户登录
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public boolean login(String uname,String pwd);
	
}
