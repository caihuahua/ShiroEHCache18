package com.shiro.user.dao;

import com.shiro.common.model.PageBean;
import com.shiro.user.vo.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {

    int insert(User user) throws SQLException;

	User login(Map<String, Object> map) throws SQLException;

	User findUserByEmail(String email) throws SQLException;

	List<User> findUserPage(PageBean<User> user) throws SQLException;
	int selectUserCount(PageBean<User> user) throws SQLException;
}