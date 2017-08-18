package com.shiro.permission.service.impl;


import com.shiro.common.model.PageBean;
import com.shiro.permission.service.RoleService;
import com.shiro.permission.vo.Role;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class RoleServiceImpl implements RoleService {


	public int deleteByPrimaryKey(Long id) throws SQLException {
		return 0;
	}

	public int insert(Role record) throws SQLException {
		return 0;
	}

	public PageBean<Role> findRolePage(Role role, int pageSize, int pageNo) throws SQLException {
		return null;
	}
}
