package com.example.demo.mapper;

import java.util.List;
import java.util.Map;

public interface ListAllMapper {
    /**
     * 查询买或卖的信息
     *
     * @param userName
     * @param type
     * @param vagetablesName
     * @return
     */
    public List<Map<String, Object>> listAll(String userName, String type, String vagetablesName);
}
