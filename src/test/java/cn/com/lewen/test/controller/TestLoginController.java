package cn.com.lewen.test.controller;


import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.com.lewen.common.Response;
import cn.com.lewen.controller.LoginController;
import cn.com.lewen.controller.RegisterController;
import cn.com.lewen.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/springmvc.xml","classpath*:/spring.xml"})
public class TestLoginController {

	private MockHttpServletRequest request;
	
	private MockHttpServletResponse response;
	
	@Resource
	private LoginController loginController;
	
	
	@Before    
    public void setUp(){    
        request = new MockHttpServletRequest();      
        request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse();      
    } 
	
	@Test
	public void testLogin(){
		
//		Assert.assertEquals("abc", registerController.doRegister(user));
		Response<Boolean> result = loginController.dologin("jingwang", "123456", request);
		System.out.println(JSON.toJSONString(result));
	}
	
	
}
