package com.example.business.controller;

import com.example.business.service.SellServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出售接口
 */
@RestController
public class SellController {
    @Autowired
    private SellServer sellServer;

//    @Autowired
//    private LogServer loglServer;

    @RequestMapping(value = "/goSell", method = RequestMethod.POST)
    public Map goSell(@RequestParam("sellUserId") int sellUserId, @RequestParam("type") int type, @RequestParam("num") double num,
                      @RequestParam("pice") double pice, @RequestParam("sum") double sum,
                      @RequestParam("yzm") String yzm, @RequestParam("jymm") String jymm) {
        Map<String, Object> Map = new HashMap<String, Object>();

        //校验手机验证码

        //校验交易密码
        boolean jyFlag = sellServer.VerificationYJ(sellUserId, jymm);
        if (!jyFlag) {
            Map.put("error", "交易密码错误");
            return Map;
        }

        //查出卖方资产
        List<Map<String, Object>> mapList = sellServer.selectAssets(sellUserId, type);
        double surplus = 0.0;
        if (mapList.size() > 0) {
            surplus = Double.parseDouble(mapList.get(0).get("surplus") + "");
        }

        //冻结资产并减少卖方资产
        int frozen = 0;//冻结
        surplus = surplus - num;
        sellServer.AssetReduction(sellUserId, type, surplus, frozen);

        //资产放到平台
        int flag = sellServer.goSell(sellUserId, type, num, pice, sum, yzm, jymm);
        if (flag != 1) {
            Map.put("error", "出售平台异常");
            return Map;
        }

        //处理手续费,更新平台手续费信息


        //记录日志

        Map.put("success", "出售成功");
        return Map;

    }
}
