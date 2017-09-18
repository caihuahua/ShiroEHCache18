package com.shiro.permission.vo;

import java.io.Serializable;

/**
 * The Class
 *
 * @author ChenCH
 *         on 2017-09-08
 */
public class RolePermission  implements Serializable {

    private Long rid;
    private Long pid;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}
