package cn.com.lewen.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.lewen.common.Response;
import cn.com.lewen.controller.RegisterController;
import cn.com.lewen.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springmvc.xml","classpath*:/spring.xml"})
public class TestRegisterController {

	private MockHttpServletRequest request;
	
	private MockHttpServletResponse response;
	
	@Resource
	private RegisterController registerController;
	
	
	@Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    } 
	
	@Test
	public void testRegister(){
		User user = new User();
		user.setUsername("jingwang");
		user.setPassword("123456");
		user.setEmail("23231@JD.COM");
//		Assert.assertEquals("abc", registerController.doRegister(user));
		Response<Boolean> result = registerController.doRegister(user,request);
		System.out.println(JSON.toJSONString(result));
	}
	
	@Test
	public void testUserExists(){
		String username = "jingwang";
		request.setParameter("username", username);
		Response<Boolean> result = registerController.isUserExists(request,response);
		System.out.println(JSON.toJSONString(result));
	}
	
}
