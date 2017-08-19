package com.shiro.permission.service.impl;

import com.shiro.common.model.PageBean;
import com.shiro.permission.service.PermissionService;
import com.shiro.permission.vo.Permission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class PermissionServiceImpl implements PermissionService {


	@Transactional
	public int insert(Permission permission) throws SQLException {
		return 0;
	}

	public int deleteByPrimaryKey(Long id) throws SQLException {
		return 0;
	}

	public PageBean<Permission> findPermissionPage(Permission permission, int pageSize, int pageNo) throws SQLException {
		return null;
	}
}
