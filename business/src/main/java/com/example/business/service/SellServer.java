package com.example.business.service;

import com.example.business.entiy.Platform;
import com.example.business.mapper.SellMapper;
import com.example.business.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class SellServer {

    @Autowired
    private SellMapper sellMapper;

    public int goSell(int sellUserId, int type, double num, double pice, double sum, String yzm, String jymm) {
        String inputTime = DateUtil.getSystemTime();
        String flag = "1";//当前状态为出售,存入平台

        Platform platform = new Platform();
        platform.setSellUserId(sellUserId);
        platform.setType(type);
        platform.setNum(num);
        platform.setPice(pice);
        platform.setSum(sum);
        platform.setInputTime(inputTime);
        platform.setFlag(flag);
        return sellMapper.goSell(platform);
    }

    public boolean VerificationYJ(int sellUserId, String jymm) {
        boolean flag = false;
        //MD5加密交易密码

        List<Map<String, Object>> list = sellMapper.VerificationYJ(sellUserId, jymm);
        if (list.size() > 0) {
            flag = true;
        }
        return flag;
    }

    public List<Map<String, Object>> selectAssets(int sellUserId, int type) {
        return sellMapper.selectAssets(sellUserId,type);
    }

    public int AssetReduction(int sellUserId, int type, double v, double surplus) {
        return sellMapper.AssetReduction(sellUserId, type,surplus);
    }

    public int goThaw(int sellUserId, int type ,int frozen) {
        return  sellMapper.goThaw(sellUserId,type,frozen);
    }
}
