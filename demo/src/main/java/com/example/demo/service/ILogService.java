package com.example.demo.service;

import java.util.Map;

public interface ILogService {
    public boolean insert(Map<String, Object> params, String id);

    public boolean update(String name, String id);

    public boolean delete(String id);

    public boolean doError(String id);
}
