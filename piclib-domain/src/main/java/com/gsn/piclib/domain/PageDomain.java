package com.gsn.piclib.domain;

import lombok.Data;

import java.util.List;

@Data
public class PageDomain<T> {
    private Integer page = 1;   //当前第几页
    private Integer pageSize = 2;  //总页数
    private Long total = 0L;  //总记录数

    private List<T> data;


}
