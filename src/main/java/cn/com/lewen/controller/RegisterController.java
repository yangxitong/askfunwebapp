package cn.com.lewen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lewen.common.Response;
import cn.com.lewen.common.ResponseCode;
import cn.com.lewen.loginregister.service.RegisterService;
import cn.com.lewen.model.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private static Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Resource
	private RegisterService registerService;

	@RequestMapping("/doRegister")
	@ResponseBody
	public Response<Boolean> doRegister(User user,HttpServletRequest request){
		
		if(user == null ||
				StringUtils.isBlank(user.getUsername())||
				StringUtils.isBlank(user.getPassword())){
			logger.error("注册用户入参不合法，user:",user);
			return new Response<Boolean>(ResponseCode.PARAM_ILLEGAL.getCode(),
					ResponseCode.PARAM_ILLEGAL.getMsg());
		}		
		try{
			boolean result = registerService.register(user);
			logger.info("注册用户结束，结果为：",result);
			return new Response<Boolean>(ResponseCode.SUCCESS.getCode(),
					ResponseCode.SUCCESS.getMsg(),result);
		} catch(Exception e){
			logger.error("注册用户异常：",e);
			return new Response<Boolean>(ResponseCode.SERVICE_EXCEPTION.getCode(),
					ResponseCode.SERVICE_EXCEPTION.getMsg());
		}
	}
	
	@RequestMapping("/isUserExists")
	@ResponseBody
	public Response<Boolean> isUserExists(HttpServletRequest request,HttpServletResponse response){
		String username = request.getParameter("username");
		if(StringUtils.isBlank(username)){
			logger.error("入参不合法，username:",username);
			return new Response<Boolean>(ResponseCode.PARAM_ILLEGAL.getCode(),
					ResponseCode.PARAM_ILLEGAL.getMsg());
		}
		try{
			boolean result = registerService.isUserNameExist(username);
			logger.info("查询用户名是否存在，结果为：",result);
			return new Response<Boolean>(ResponseCode.SUCCESS.getCode(),
					ResponseCode.SUCCESS.getMsg(),result);
		} catch(Exception e){
			logger.error("查询用户名是否存在：",e);
			return new Response<Boolean>(ResponseCode.SERVICE_EXCEPTION.getCode(),
					ResponseCode.SERVICE_EXCEPTION.getMsg());
		}
	}
	
}
