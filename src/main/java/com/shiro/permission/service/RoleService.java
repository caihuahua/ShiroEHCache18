package com.shiro.permission.service;

import com.shiro.common.model.PageBean;
import com.shiro.permission.vo.Role;

import java.sql.SQLException;

public interface RoleService {

	int deleteByPrimaryKey(Long id) throws SQLException;

    int insert(Role record) throws SQLException;

    PageBean<Role> findRolePage(Role role,int pageSize,int pageNo) throws SQLException;
}
