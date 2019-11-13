package com.example.demo.controller;

import com.example.demo.service.OrderServer;
import com.example.demo.service.SellServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单接口
 */
@RestController
public class OrderController {

    @Autowired
    private OrderServer orderServer;

    //匹配订单并生成
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Map order(@RequestParam("sellUserId") int sellUserId, @RequestParam("buyUserId") int buyUserId,
                     @RequestParam("type") int type, @RequestParam("num") double num,
                     @RequestParam("pice") double pice, @RequestParam("sum") double sum, @RequestParam("kc") int kc,
                     @RequestParam("yzm") String yzm, @RequestParam("jymm") String jymm,
                     @RequestParam("totalMoney") double totalMoney, @RequestParam("mobilePhone") int mobilePhone) {

        Map<String, Object> Map = new HashMap<String, Object>();

        //记录发布表
        int flag = 2;//买入
        int status = 1;//交易中
        int dealId = orderServer.setDeal(buyUserId, flag, num, pice, totalMoney, status, type, mobilePhone);
        //生成订单
        int totalStatus = 1;//匹配成功
        int fileType = 1;//是否上传了凭证,此处未上传
        orderServer.generationOrder(buyUserId, sellUserId, sum, totalStatus, dealId, kc, num, pice, fileType);
        Map.put("success", "订单生成");
        return Map;
    }
}
