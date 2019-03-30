package com.example.demo1.ConfigDto;

import com.example.demo1.ConfigDto.BaseDto;
import com.example.demo1.ConfigDto.PageBaseVo;

import java.util.Collection;

public class PageDto<T> extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = -987192595654503608L;

    private int total;

    private int rows;

    private int currPage;

    private int pageSize;

    private Collection<T> list;

    public PageDto() {
        super();
    }

    public PageDto(boolean success, String message) {
        super(success, message);
    }

    public PageDto(boolean success) {
        super(success);
    }

    public PageDto(int total, PageBaseVo vo, Collection<T> list) {
        super(true);
        this.total = total;
        this.rows = (list == null ? 0 : list.size());
        this.currPage = vo.getCurrPage();
        this.pageSize = vo.getPageSize();
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Collection<T> getList() {
        return list;
    }

    public void setList(Collection<T> list) {
        this.list = list;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
