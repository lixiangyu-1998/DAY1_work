package com.lixiangyu.pagingQuery.service.Impl;

import com.lixiangyu.pagingQuery.bean.User;
import com.lixiangyu.pagingQuery.dao.Impl.PageDaoImpl;
import com.lixiangyu.pagingQuery.service.PageService;

import java.util.List;

/**
 * @author lixiangyu
 * @title: PageServiceImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1110:31 下午
 */
public class PageServiceImpl implements PageService {
    @Override
    public List<User> queryLimit(Integer page, Integer pageSize, User user) {
        return new PageDaoImpl().queryLimit(page,pageSize,user);
    }

    @Override
    public Integer queryAllUser(User user) {
        return new PageDaoImpl().queryAllUser(user);
    }
}
