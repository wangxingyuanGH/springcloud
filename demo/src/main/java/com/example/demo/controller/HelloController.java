package com.example.demo.controller;

import com.example.demo.aspect.ServiceLog;
import com.example.demo.entiy.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建一个RESTful API的实现代码    同SpringMVC一样  但是不需要像SpringMVC写太多配置   直接从Controller开始
 * @author Administrator
 *
 */
@RestController
public class HelloController {
	@Autowired
	private UserService userService;
	@ServiceLog(operation = "启动类。。")
	@RequestMapping("/hello")
	public String index() {
		long beginTime=System.currentTimeMillis();
		User user = userService.selectByPrimaryKey(1);
        long time=System.currentTimeMillis()-beginTime;
		return "Hello SpringBoot"+user.getName()+",消耗查询时间："+time;
		
	}
	
	
}
