package com.csw.service;

import com.csw.entity.Xiaoz;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface XiaozService {

    List<Xiaoz> queryAll();

    void add(Xiaoz xiaoz);

    List<Xiaoz> queryAll2();

    List<Xiaoz> findBy(Integer parentId);
}
