package com.shiro.permission.service;


import com.shiro.common.model.PageBean;
import com.shiro.permission.vo.Permission;

import java.sql.SQLException;

public interface PermissionService {

	int insert(Permission permission) throws SQLException;

	int deleteByPrimaryKey(Long id) throws SQLException;

	PageBean<Permission> findPermissionPage(Permission permission,int pageSize,int pageNo) throws SQLException;
}
