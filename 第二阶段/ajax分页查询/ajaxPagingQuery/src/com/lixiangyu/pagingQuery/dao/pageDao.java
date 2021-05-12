package com.lixiangyu.pagingQuery.dao;

import com.lixiangyu.pagingQuery.bean.User;

import java.util.List;

/**
 * @author lixiangyu
 * @title: pageDao
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/119:23 下午
 */
public interface pageDao {
    /**
     * 分页
     * @param page
     * @param pageSize
     * @param queryUser
     * @return
     */
    public List<User> queryLimit(Integer page,Integer pageSize,User queryUser);

    /**
     * 查总数
     * @param queryUser
     * @return
     */
    public Integer queryAllUser(User queryUser);
}
