package com.example.demo.controller;

import com.example.demo.service.ListAllServeice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ListAllController {
    @Autowired
    private ListAllServeice listAllServeice;

    /**
     * 查询买或卖的信息
     * @param userName
     * @param type
     * @param vagetablesName
     * @return
     */
    @RequestMapping(value = "/listAll", method = RequestMethod.POST)
    public List<Map<String, Object>> listAll(@RequestParam("userName") String userName, @RequestParam("type") String type, @RequestParam("vagetablesName") String vagetablesName) {
        return listAllServeice.listAll(userName, type, vagetablesName);
    }
}
