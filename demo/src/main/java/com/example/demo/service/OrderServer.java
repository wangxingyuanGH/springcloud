package com.example.demo.service;

import com.example.demo.entiy.Deal;
import com.example.demo.entiy.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServer {
    @Autowired
    private OrderMapper orderMapper;

    public int generationOrder(int buyUserId, int sellUserId, double sum, int totalStatus, int dealId, int kc, double num, double pice, int fileType) {
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
        order.setBuys_fee(1);//
        order.setPay_fee(1);//
        order.setCreate_time(DateUtil.getSystemTime());

        return orderMapper.generationOrder(order);
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
        return orderMapper.setDeal(deal);
    }

}
