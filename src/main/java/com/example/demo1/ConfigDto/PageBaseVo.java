package com.example.demo1.ConfigDto;

import com.example.demo1.ConfigDto.BaseVo;

import javax.validation.constraints.NotNull;

public class PageBaseVo extends BaseVo {

    /**
     *
     */
    private static final long serialVersionUID = 6406044761329856989L;

    @NotNull(message = "{currPage.isNull}")
    private int currPage;

    @NotNull(message = "{pageSize.isNull}")
    private int pageSize;

    public PageBaseVo() {
        super();
    }

    public PageBaseVo(int currPage, int pageSize) {
        super();
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    @Override
    public String toString(){
        return "PageBaseVo{" + "currPage=" + currPage + ", pageSize=" + pageSize + '}';
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


}
