package com.example.demo.service;

import com.example.demo.mapper.ListAllMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class ListAllServeice {
    @Autowired
    private ListAllMapper listAllMapper;

    public List<Map<String, Object>> listAll(String userName, String type, String vagetablesName) {
        return listAllMapper.listAll(userName, type, vagetablesName);
    }
}
