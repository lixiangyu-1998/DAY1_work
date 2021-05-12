package com.lixiangyu.pagingQuery.bean;

import lombok.*;

/**
 * @author lixiangyu
 * @title: PageInfo
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/119:04 下午
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class PageInfo {
    private Integer page;
    private Integer pageSize;
    private Integer totalPage;

    public PageInfo(Integer page, Integer pageSize, Integer total) {
        this.page = page;
        this.pageSize = pageSize;
        int set = (int) Math.ceil(total * 1.0 / pageSize);
        if (set == 0) {
            set = 1;
        }
        this.totalPage = set;
    }
}
