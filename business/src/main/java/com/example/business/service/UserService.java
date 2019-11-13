package com.example.business.service;

import com.example.business.entiy.User;
import com.example.business.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	@Cacheable(value="user", key="'user'")
    public User selectByPrimaryKey(Integer id) {
        System.out.println("开始查询.....");
        try {
            Thread.sleep(3 * 1000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("查询结束......");
        User user=userMapper.selectByPrimaryKey(id);

        return user;
    }
	
}
