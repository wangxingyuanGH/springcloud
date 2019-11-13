package com.example.springcloudclient.mapper;

import com.example.springcloudclient.entiy.User;

public interface UserMapper {
    User selectByPrimaryKey(Integer id);
}
