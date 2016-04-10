package cn.com.lewen.dao;

import org.apache.ibatis.annotations.Param;

import cn.com.lewen.model.User;


public interface UserMapper {
	
	/**
	 * 插入User记录
	 * @param user
	 * @return
	 */
	int insert(User user);
	
	/**
	 * 根据账户名查询是否有此账户
	 * @param username
	 * @return
	 */
	int findUserByUsername(String username);
	
	/**
	 * 根据账户名和密码查询用户信息
	 * @param username
	 * @param password
	 * @return
	 */
	User findUser(@Param("username") String username,@Param("password") String password);

}
