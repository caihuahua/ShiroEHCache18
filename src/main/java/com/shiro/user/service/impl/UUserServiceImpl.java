package com.shiro.user.service.impl;

import com.shiro.user.dao.UserDao;
import com.shiro.common.model.PageBean;
import com.shiro.user.vo.User;
import com.shiro.user.service.UUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UUserServiceImpl implements UUserService {
    @Resource
    UserDao userDao;

    public int insert(User user) throws SQLException {
        return userDao.insert(user);
    }

    public User login(String email ,String pswd) throws SQLException {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("email",email);
        map.put("pswd",pswd);
        User login = userDao.login(map);
        return login;
    }

    public User findUserByEmail(String email) throws SQLException {
        return userDao.findUserByEmail(email);
    }

    public PageBean<User> findUserPage(User user, int pageSize, int pageNo) throws SQLException {
        PageBean<User> pb=new PageBean();
        pb.setPageNo(pageNo);
        pb.setPageSize(pageSize);
        pb.setParam(user);
        int count = userDao.selectUserCount(pb);
        pb.setCount(count);
        List<User> page = userDao.findUserPage(pb);
        pb.setData(page);
        return pb;
    }
}
