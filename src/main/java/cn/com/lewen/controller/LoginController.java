package cn.com.lewen.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lewen.common.Response;
import cn.com.lewen.common.ResponseCode;
import cn.com.lewen.loginregister.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource
	private LoginService loginService;

	@RequestMapping("/dologin")
	@ResponseBody
	public Response<Boolean> dologin(String uname,String pwd,
			String code,HttpServletRequest request){
		if(StringUtils.isBlank(uname)||
				StringUtils.isBlank(pwd) || StringUtils.isBlank(code)){
			logger.error("登录入参不合法，uname:",uname,",password:",pwd,",code:",code);
			return new Response<Boolean>(ResponseCode.PARAM_ILLEGAL.getCode(),
					ResponseCode.PARAM_ILLEGAL.getMsg());
		}		
		try{
			String sessionCode = (String) request.getSession().getAttribute("code");
			if(!code.equals(sessionCode)){
				logger.error("验证码输入错误，session中验证码为：",sessionCode);
				return new Response<Boolean>(ResponseCode.PARAM_ILLEGAL.getCode(),
						ResponseCode.PARAM_ILLEGAL.getMsg());
			}
			boolean result = loginService.login(uname, pwd);
			logger.info("登录用户结束，结果为：",result);
			//将登录信息放入session中
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			return new Response<Boolean>(ResponseCode.SUCCESS.getCode(),
					ResponseCode.SUCCESS.getMsg(),result);
		} catch(Exception e){
			logger.error("登录用户异常：",e);
			return new Response<Boolean>(ResponseCode.SERVICE_EXCEPTION.getCode(),
					ResponseCode.SERVICE_EXCEPTION.getMsg());
		}
	}
	

	
}
