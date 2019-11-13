package com.example.business.controller;

import com.example.business.service.OrderServer;
import com.example.business.service.SellServer;
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
    @Autowired
    private SellServer sellServer;

    //生成订单
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
        long orderNumber = orderServer.generationOrder(buyUserId, sellUserId, sum, totalStatus, dealId, kc, num, pice, fileType);
        Map.put("success", "订单生成" + orderNumber);
        return Map;
    }

    //支付订单
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Map order(@RequestParam("buyUserId") int buyUserId, @RequestParam("orderNumber") long orderNumber) {
        Map<String, Object> Map = new HashMap<String, Object>();
        int status = 2;//支付
        orderServer.updateStatus(buyUserId, orderNumber, status);
        Map.put("success", "支付完成" + orderNumber);
        return Map;

    }

    //完成订单
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Map completeOrder(@RequestParam("buyUserId") int buyUserId, @RequestParam("type") int type, @RequestParam("sellUserId") int sellUserId, @RequestParam("orderNumber") long orderNumber) {
        Map<String, Object> Map = new HashMap<String, Object>();
        int status = 4;//完成
        orderServer.completeOrder(buyUserId, orderNumber, status);

        //发布表更新完成状态
        int fb_status = 2;//完成
        orderServer.AssetReduction(buyUserId,type,fb_status);

        //订单完成后，解冻双方资产
        int frozen = 1;//解冻
        sellServer.goThaw(buyUserId, type,frozen);
        sellServer.goThaw(sellUserId, type,frozen );
        Map.put("success", "订单完成" + orderNumber);
        return Map;

    }

    //取消订单
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public Map cancelOrder(@RequestParam("buyUserId") int buyUserId, @RequestParam("type") int type, @RequestParam("sellUserId") int sellUserId, @RequestParam("orderNumber") long orderNumber) {
        Map<String, Object> Map = new HashMap<String, Object>();
        int status = 4;//取消
        orderServer.cancelOrder(buyUserId, orderNumber, status);
        //发布表更新取消状态
        int fb_status = 6;//取消
        orderServer.AssetReduction(buyUserId,type,fb_status);

        //订单取消后，解冻双方资产
        int frozen = 1;//解冻
        sellServer.goThaw(buyUserId, type,frozen);
        sellServer.goThaw(sellUserId, type,frozen );
        Map.put("success", "订单取消" + orderNumber);
        return Map;

    }

}
