package cn.com.lewen.loginregister.service;

import cn.com.lewen.model.User;

public interface RegisterService {
	
	/**
	 * 用户的注册
	 * @param user
	 * @return
	 */
	boolean register(User user);
	
	/**
	 * 用户名是否存在
	 * @param username
	 * @return
	 */
	boolean isUserNameExist(String username);
	
}
