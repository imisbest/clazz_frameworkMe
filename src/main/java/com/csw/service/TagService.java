package com.csw.service;

import com.csw.entity.Taglib;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface TagService {
    List<Taglib> queryAll();

    void add(Taglib taglib);


    List<Taglib> queryByC();

    List<Taglib> queryByS();
}
