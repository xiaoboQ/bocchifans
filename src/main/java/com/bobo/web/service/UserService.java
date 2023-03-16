package com.bobo.web.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bobo.web.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    public List<User> selectList(LambdaQueryWrapper<User> lambdaQueryWrapper);
}
