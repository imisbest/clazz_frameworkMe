package com.csw.dao;

import com.csw.entity.Clazz;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface ClazzDao {
    List<Clazz> queryAll();

    void add(@Param("c") Clazz clazz);

    List<Clazz> queryAllByName(@Param("name") String name);
}
