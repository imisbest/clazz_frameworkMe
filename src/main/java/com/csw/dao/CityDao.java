package com.csw.dao;

import com.csw.entity.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface CityDao {
    List<City> queryAll();

    void add(@Param("c") City city);
}
