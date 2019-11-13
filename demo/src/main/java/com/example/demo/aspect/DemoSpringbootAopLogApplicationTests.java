package com.example.demo.aspect;

import com.example.demo.service.ILogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoSpringbootAopLogApplicationTests {

	@Autowired
	ILogService logService;

	@Test
	public void contextLoads() {
		Map<String, Object> params = new HashMap<>();
		params.put("key1", "v1");
		params.put("key2", "v2");

		logService.insert(params, "111");
		logService.update("king", "kang");
		logService.delete("111");
		logService.doError("111");
	}

}