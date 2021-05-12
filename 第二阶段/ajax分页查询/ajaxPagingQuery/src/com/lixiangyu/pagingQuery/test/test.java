package com.lixiangyu.pagingQuery.test;

import com.lixiangyu.pagingQuery.bean.User;
import com.lixiangyu.pagingQuery.dao.Impl.PageDaoImpl;
import org.junit.Test;

/**
 * @author lixiangyu
 * @title: test
 * @projectName untitled
 * @description: TODO
 * @date 2021/5/126:48 下午
 */
public class test {
    private static com.lixiangyu.pagingQuery.dao.pageDao pageDao=new PageDaoImpl();
@Test
    public static void main(String[] args) {
    System.out.println(pageDao.queryLimit(1, 5, new User("小明", "xxxx")));
}
}
