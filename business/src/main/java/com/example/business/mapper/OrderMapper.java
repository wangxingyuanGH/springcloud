package com.example.business.mapper;

import com.example.business.entiy.Deal;
import com.example.business.entiy.Order;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface OrderMapper {

    int generationOrder(Order order);

    int setDeal(Deal deal);

    int updateStatus(int buyUserId, long lock_id,int status);

    int completeOrder(int buyUserId, long orderNumber,int status);

    int cancelOrder(int buyUserId, long orderNumber, int status);

    int AssetReduction(int buyUserId, int type, int fb_status);
}
