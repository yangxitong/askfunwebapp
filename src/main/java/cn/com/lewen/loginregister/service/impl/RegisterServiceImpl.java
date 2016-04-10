package cn.com.lewen.loginregister.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.lewen.dao.UserMapper;
import cn.com.lewen.loginregister.service.RegisterService;
import cn.com.lewen.model.User;
import cn.com.lewen.utils.EncryptUtil;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	private static Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Resource
	private UserMapper userMapper;

	@Override
	@Transactional
	public boolean register(User user) {
		if(user == null){
			logger.error("注册的用户信息为空，方法退出");
			return false;
		}
		//对密码进行MD5加密
		user.setPassword(EncryptUtil.generatePassword(user.getPassword()));
		user.setIsGuide(User.UserStatus.IS_NOT_GUIDE.getVal());
		user.setIsAdmin(User.UserStatus.IS_NOT_ADMIN.getVal());
		int result = userMapper.insert(user);
		logger.info("注册用户结果，result ： ",result,"用户 名："+user.getUsername());
		return result > 0 ? true : false;
	}

	@Override
	public boolean isUserNameExist(String username) {
		if(StringUtils.isBlank(username)){
			logger.error("输入的用户名为空，方法退出");
			return false;
		}
		int result = userMapper.findUserByUsername(username);
		return result > 0 ?true : false;
	}

}
