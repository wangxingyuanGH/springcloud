package com.example.business.service;

import com.example.business.entiy.Deal;
import com.example.business.entiy.Order;
import com.example.business.mapper.OrderMapper;
import com.example.business.util.DateUtil;
import com.example.business.util.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServer {
    @Autowired
    private OrderMapper orderMapper;

    public long generationOrder(int buyUserId, int sellUserId, double sum, int totalStatus, int dealId, int kc, double num, double pice, int fileType) {
        Order order = new Order();
        order.setOrder_sn("00");
        order.setUserid(buyUserId);
        order.setPassid(sellUserId);
        order.setTotal_price(sum);
        order.setOrder_status(totalStatus);
        order.setDeal_id(dealId);
        order.setSku_id(kc);
        order.setTotal(num);
        order.setPrice(pice);
        order.setFile_type(fileType);
        SnowFlake idWorker = new SnowFlake(0, 0);
        order.setLock_id(buyUserId+idWorker.nextId());
        order.setBuys_fee(1);//
        order.setPay_fee(1);//
        order.setCreate_time(DateUtil.getSystemTime());
        order.setUpdate_time("0000-00-00 00:00:00");
                orderMapper.generationOrder(order);
        return order.getLock_id();
    }


    public int setDeal(int buyUserId, int flag, double num, double pice, double totalMoney, int status, int vagetablesId, int mobilePhone) {

        Deal deal = new Deal();
        deal.setUserid(buyUserId);
        deal.setType(flag);
        deal.setDeal_total(num);
        deal.setPrice(pice);
        deal.setTotalmoney(totalMoney);
        deal.setStatus(status);
        deal.setVagetables_id(vagetablesId);
        deal.setMobile_phone(mobilePhone);
        deal.setCreatime(DateUtil.getSystemTime());
        deal.setUpdatetime("0000-00-00 00:00:00");
        orderMapper.setDeal(deal);
        return  deal.getId();
    }

    public int updateStatus(int buyUserId, long orderNumber,int status) {
        return orderMapper.updateStatus(buyUserId,orderNumber,status);
    }


    public int completeOrder(int buyUserId, long orderNumber,int status) {
        return orderMapper.completeOrder(buyUserId,orderNumber,status);
    }

    public int cancelOrder(int buyUserId, long orderNumber, int status) {
        return orderMapper.cancelOrder(buyUserId,orderNumber,status);
    }

    public int AssetReduction(int buyUserId, int type, int fb_status) {
        return orderMapper.AssetReduction(buyUserId,type,fb_status);
    }
}
