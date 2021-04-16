package com.csw.dao;

import com.csw.entity.Taglib;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface TagDao {
    List<Taglib> queryAll();

    void add(@Param("t") Taglib taglib);

    List<Taglib> queryByC();

    List<Taglib> queryByS();
}
