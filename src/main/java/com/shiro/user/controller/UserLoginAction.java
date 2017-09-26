package com.shiro.user.controller;

import com.shiro.common.model.Result;
import com.shiro.user.service.UUserService;
import com.shiro.user.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Date;

/**
 * The Class
 *
 * @author ChenCH
 *         on 2017-08-19
 */
@Controller
public class UserLoginAction {

    @Autowired
    UUserService userService;

    /**
     * 注册
     *
     * @param user
     * @return
     * @throws SQLException
     */
    @RequestMapping("/subRegister")
    @ResponseBody
    public Object subRegister(User user) throws SQLException {
        String email = user.getEmail();
        Result result = new Result();
        User userByEmail = userService.findUserByEmail(email);
        if (userByEmail != null) {
            result.setState("false");
            result.setMessage("帐号|Email已经存在！");
            return result;
        }
        Date date = new Date();
        user.setCreateTime(date);
        user.setLastLoginTime(date);
        //设置有效
        user.setStatus(User._1);
        boolean insert = userService.insert(user);
        if (insert) {
            result.setState("true");
            result.setMessage("注册成功！");
        } else {
            result.setState("false");
            result.setMessage("注册失败");
        }
        return result;
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @RequestMapping("/subLogin")
    @ResponseBody
    public Object subLogin(User user) {
        Result result = new Result();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getEmail(), user.getPswd());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            result.setState("true");
            result.setMessage("登录成功！");
        } catch (AuthenticationException ex) {
            result.setState("false");
            result.setMessage("用户名或密码错误");
        }
        return result;
    }
}
