package com.example.demo.mapper;

import com.example.demo.entiy.Platform;

import java.util.List;
import java.util.Map;

public interface SellMapper {

    int goSell(Platform platform);

    List<Map<String, Object>> VerificationYJ(int sellUserId, String jymm);

    List<Map<String, Object>> selectAssets(int sellUserId, int type);

    int AssetReduction(int sellUserId, int type, double surplus);

    int goThaw(int sellUserId, int type);
}
