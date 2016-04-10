package cn.com.lewen.loginregister.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.com.lewen.dao.UserMapper;
import cn.com.lewen.loginregister.service.LoginService;
import cn.com.lewen.model.User;
import cn.com.lewen.utils.EncryptUtil;

@Service
public class LoginServiceImpl implements LoginService{
	
private static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;

	@Override
	public boolean login(String uname, String pwd) {
		if(StringUtils.isBlank(uname)||
				StringUtils.isBlank(pwd)){
			logger.error("登录用户名或者密码为空，方法退出");
			return false;
		}
		pwd = EncryptUtil.generatePassword(pwd);
		User user = userMapper.findUser(uname, pwd);
		return (user == null) ? false : true;
	}
	
}
