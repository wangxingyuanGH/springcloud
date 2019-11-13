package com.example.business.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface ILogService {
    public boolean insert(Map<String, Object> params, String id);

    public boolean update(String name, String id);

    public boolean delete(String id);

    public boolean doError(String id);
}
