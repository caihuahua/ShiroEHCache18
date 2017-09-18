package com.shiro.permission.vo;

import java.io.Serializable;

/**
 * The Class
 *用户和权限的关联表
 * @author ChenCH
 *         on 2017-09-08
 */
public class UserRole implements Serializable {
    private Long uid;
    private Long rid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}
