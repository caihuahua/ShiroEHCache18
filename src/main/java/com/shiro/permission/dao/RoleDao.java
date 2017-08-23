package com.shiro.permission.dao;

import com.shiro.common.model.PageBean;
import com.shiro.permission.vo.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(Role role);

    List<Role> findRolePage(PageBean<Role> rolePageBean) throws SQLException;
    int findRoleCount(PageBean<Role> rolePageBean) throws SQLException;

    List<String> selectRoleByUser(String userNo) throws SQLException;
}