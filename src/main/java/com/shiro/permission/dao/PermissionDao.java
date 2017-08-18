package com.shiro.permission.dao;

import com.shiro.common.model.PageBean;
import com.shiro.permission.vo.Permission;

import java.sql.SQLException;
import java.util.List;

public interface PermissionDao {

    int insert(Permission permission) throws SQLException;

    int deleteByPrimaryKey(Long id) throws SQLException;

    List<Permission> findPermissionPage(PageBean<Permission> permissionPageBean) throws SQLException;
    int findPermissionCount(PageBean<Permission> permissionPageBean) throws SQLException;
}