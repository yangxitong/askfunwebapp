package cn.com.lewen.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.lewen.common.Response;
import cn.com.lewen.common.ResponseCode;

@Controller
@RequestMapping("/vertifyCode")
public class VertifyCodeController {

	
	@RequestMapping(value="/getCode",method={RequestMethod.GET,RequestMethod.POST},produces = "application/json; charset=utf-8")
	@ResponseBody
	public Response<String> getCode(HttpServletRequest request,HttpServletResponse response){
		String code = generateCode();
		request.getSession().setAttribute("code", code);
		return new Response<String>(ResponseCode.SUCCESS.getCode(),
				ResponseCode.SUCCESS.getMsg(),code );
	}
	
	/**
	 * 随机生成四位数字的验证码
	 * @return
	 */
	private String generateCode(){
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for(int i= 0;i<4;i++){
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	
}
