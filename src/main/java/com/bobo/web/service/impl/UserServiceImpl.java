package com.bobo.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.web.entity.User;
import com.bobo.web.mapper.UserMapper;
import com.bobo.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectList(LambdaQueryWrapper<User> lambdaQueryWrapper) {
        return userMapper.selectList(lambdaQueryWrapper);
    }
}
