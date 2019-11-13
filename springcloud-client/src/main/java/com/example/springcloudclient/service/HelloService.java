package com.example.springcloudclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    // 断路器配置，当无法调用如下方法时，就会调用自定的hiError方法。
    @HystrixCommand(fallbackMethod = "hisError")
    public String hiService(String name) {
        return "hello!" + name;
    }

    public String hisError(String name) {
        return "hey " +
                name + ", there is some problem with hi page";
    }
}