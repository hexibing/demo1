package com.example.demo1.ConfigDto;

import com.example.demo1.ConfigDto.BaseDto;

import java.util.Collection;

public class ListDto<T> extends BaseDto {

    private static final long serialVersionUID = -3540535850314707522L;

    private Collection<T> list;

    private int total;

    public ListDto() {
        super();
    }

    public ListDto(boolean success) {
        super(success);
    }

    public ListDto(Collection<T> list) {
        super(true);
        this.list = list;
    }

    public ListDto(Collection<T> list, int total) {
        super(true);
        this.list = list;
        this.total = total;
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

    public int getTotal(){
        return total;
    }

    public void setTotal(int total){
        this.total = total;
    }



}
