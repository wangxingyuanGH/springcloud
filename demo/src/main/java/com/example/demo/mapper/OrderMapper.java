package com.example.demo.mapper;

import com.example.demo.entiy.Deal;
import com.example.demo.entiy.Order;

public interface OrderMapper {

    public int generationOrder(Order order);

    int setDeal(Deal deal);
}
