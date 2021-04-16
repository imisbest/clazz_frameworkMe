package com.csw.service;

import com.csw.entity.Infos;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface InfoService {
    List<Infos> queryAll();

    List<Infos> queryAll3();

    List<Infos> queryAll5();

    Infos queryAll5id(Integer id);

    void delete(Integer id);

    void insert(Infos infos);

    void update(Infos infos);

    List<Infos> query2(String tag, String into);
}
