package com.lixiangyu.pagingQuery.dao.Impl;

import com.lixiangyu.pagingQuery.bean.User;
import com.lixiangyu.pagingQuery.dao.BaseDao;
import com.lixiangyu.pagingQuery.dao.pageDao;

import java.util.List;

/**
 * @author lixiangyu
 * @title: PageDaoImpl
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/1110:07 下午
 */
public class PageDaoImpl extends BaseDao implements pageDao {
    @Override
    public List<User> queryLimit(Integer page, Integer pageSize, User user) {
       String sql="SELECT * FROM t_userInfo ";
        //SELECT * FROM t_userInfo WHERE name='小明'AND address LIKE 'xxxx' LIMIT 0,5 ;
        StringBuilder builder = sqlAppend(sql, user,"LIMIT ?,?");
       return queryForList(User.class,builder.toString(),(page - 1)*pageSize,pageSize);
    }

    @Override
    public Integer queryAllUser(User user) {
        String sql="SELECT * FROM t_userInfo ";
        //SELECT * FROM t_userInfo  WHERE name='小明'AND address LIKE 'xxxx' ORDER BY id desc LIMIT 1;
        StringBuilder builder = sqlAppend(sql, user,"ORDER BY id desc LIMIT 1");
        return queryForOne(User.class,builder.toString()).getId();
    }
}
