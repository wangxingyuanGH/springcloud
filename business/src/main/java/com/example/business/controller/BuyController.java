package com.example.business.controller;

import com.example.business.service.SellServer;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 购买接口
 */
@RestController
public class BuyController {
    @Autowired
    private SellServer sellServer;

    @RequestMapping(value = "/goBuy", method = RequestMethod.POST)
    public Map goSell(@RequestParam("sellUserId") int sellUserId, @RequestParam("buyUserId") int buyUserId,
                      @RequestParam("type") int type, @RequestParam("num") double num,
                      @RequestParam("pice") double pice, @RequestParam("sum") double sum,
                      @RequestParam("yzm") String yzm, @RequestParam("jymm") String jymm) {

        Map<String, Object> Map = new HashMap<String, Object>();
        //校验手机验证码

        //校验交易密码
        boolean jyFlag = sellServer.VerificationYJ(buyUserId, jymm);
        if (!jyFlag) {
            Map.put("error", "交易密码错误");
            return Map;
        }

        //冻结资产
        int frozen = 0;//冻结
        sellServer.goThaw(buyUserId, type,frozen);

        Map.put("success", "验证通过");
        return Map;


    }
}
