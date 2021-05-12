package com.lixiangyu.pagingQuery.service;

import com.lixiangyu.pagingQuery.bean.User;

import java.util.List;

/**
 * @author lixiangyu
 * @title: PageService
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1110:30 下午
 */
public interface PageService {
    /**
     * 分页
     * @param page
     * @param pageSize
     * @param user
     * @return
     */
    public List<User> queryLimit(Integer page, Integer pageSize, User user);

    /**
     * 查总数
     * @param user
     * @return
     */
    public Integer queryAllUser(User user);
}
