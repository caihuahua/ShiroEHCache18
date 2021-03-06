package com.shiro.user.service;

import com.shiro.common.model.PageBean;
import com.shiro.user.vo.User;

import java.sql.SQLException;

public interface UUserService {

    boolean insert(User user) throws SQLException;

    User login(User user) throws SQLException;

    User findUserByEmail(String email) throws SQLException;

    PageBean<User> findUserPage(User user,int pageSize,int pageNo) throws SQLException;
}
