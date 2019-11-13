package com.example.business.mapper;

import com.example.business.entiy.Platform;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface SellMapper {

    int goSell(Platform platform);

    List<Map<String, Object>> VerificationYJ(int sellUserId, String jymm);

    List<Map<String, Object>> selectAssets(int sellUserId, int type);

    int AssetReduction(int sellUserId, int type, double surplus);

    int goThaw(int sellUserId, int type,int frozen);
}
