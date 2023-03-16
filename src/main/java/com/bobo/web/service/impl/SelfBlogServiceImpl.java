package com.bobo.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bobo.web.entity.SelfBlog;
import com.bobo.web.mapper.SelfBlogMapper;
import com.bobo.web.service.SelfBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SelfBlogServiceImpl extends ServiceImpl<SelfBlogMapper, SelfBlog> implements SelfBlogService {

    @Resource
    private SelfBlogMapper selfBlogMapper;
}
