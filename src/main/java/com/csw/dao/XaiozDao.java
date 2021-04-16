package com.csw.dao;

import com.csw.entity.Xiaoz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface XaiozDao {
    List<Xiaoz> queryAll();

    void add(@Param("x") Xiaoz xiaoz);

    List<Xiaoz> queryAll2();

    List<Xiaoz> findBy(@Param("id") Integer parentId);
}
