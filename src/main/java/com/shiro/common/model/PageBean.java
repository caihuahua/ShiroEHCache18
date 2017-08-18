package com.shiro.common.model;

import java.util.List;

/**
 * The Class
 *
 * @author ChenCH
 *         on 2017-07-12
 */
public class PageBean<T> {
    private int start;//每页开始的记录数
    private int count;//总记录数
    private int pageNo;//页码
    private int pageSize=10;//每页的条数
    private List<T> data;
    private T param;


    public int getStart() {
        start=(pageNo-1)*pageSize;
        return start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }

}
