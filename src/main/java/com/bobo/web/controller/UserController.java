package com.bobo.web.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bobo.web.bean.Result;
import com.bobo.web.bean.dto.PersonalInfoDto;
import com.bobo.web.bean.vo.RegisterVo;
import com.bobo.web.entity.User;
import com.bobo.web.service.UserService;
import com.bobo.web.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Vector;

@Slf4j
@RestController
@RequestMapping("/users")
//解决post跨域请求
@CrossOrigin
@Api(tags = "用户接口")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("注册")
    @PostMapping
    public Result<Object> register(@RequestBody RegisterVo registerVo){
        User user = new User();
        BeanUtil.copyProperties(registerVo, user);

        //先判断是否存在邮箱重复，其次判断是否存在用户名重复
        LambdaQueryWrapper<User> lqwEmail = new LambdaQueryWrapper<>();
        lqwEmail.eq(User::getEmail, user.getEmail());
        if(userService.selectList(lqwEmail) != null && !userService.selectList(lqwEmail).isEmpty()){
            return Result.fail("当前邮箱已被注册");
        }

        LambdaQueryWrapper<User> lqwUserName = new LambdaQueryWrapper<>();
        lqwUserName.eq(User::getUsername, user.getUsername());
        if(userService.selectList(lqwUserName) != null && !userService.selectList(lqwEmail).isEmpty()){
            return Result.fail("当前用户名已被注册");
        }
        //保存当前用户提交的信息
        userService.save(user);
        return Result.success("成功注册", null);
    }

    @ApiOperation("登录")
    @GetMapping
    public Result<Object> login(@RequestParam("email") String email, @RequestParam("password") String password){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getEmail, email);
        lqw.eq(User::getPassword, password);
        if(userService.selectList(lqw) != null && !userService.selectList(lqw).isEmpty()){
            return Result.success("登陆成功", null);
        }else{
            return Result.fail("邮箱或密码不正确");
        }
    }

    @ApiOperation("获取用户名")
    @GetMapping("/username")
    public Result<String> getUsername(@RequestParam("email") String email){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getEmail, email);
        if(userService.selectList(lqw) != null && !userService.selectList(lqw).isEmpty()){
            User user = userService.selectList(lqw).get(0);
            return Result.success("查询成功", user.getUsername());
        }else{
            return Result.fail("邮箱不正确");
        }
    }

    @ApiOperation("获取个人信息")
    @GetMapping("/personInfo")
    public Result<PersonalInfoDto> getPersonInfo(@RequestParam("email") String email){
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getEmail, email);
        if(userService.selectList(lqw) != null && !userService.selectList(lqw).isEmpty()){
            User user = userService.selectList(lqw).get(0);
            //获取入站时间
            Date datePast = user.getCreateTime();
            //获取当前时间
            Date dateNow = new Date();
            //分别获取过去的天，小时，分钟，秒的列表
            Vector<Long> times = DateUtil.dateSubtraction(datePast, dateNow);
            //生成结果的Dto
            PersonalInfoDto personalInfoDto = new PersonalInfoDto();
            //分别设置对应的属性
            personalInfoDto.setUsername(user.getUsername());
            personalInfoDto.setDay(times.get(0));
            personalInfoDto.setHour(times.get(1));
            personalInfoDto.setMin(times.get(2));
            personalInfoDto.setSec(times.get(3));

            return Result.success("查询成功", personalInfoDto);
        }else{
            return Result.fail("邮箱不正确");
        }
    }
}
