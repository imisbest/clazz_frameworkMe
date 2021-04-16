package com.csw.service;

import com.csw.entity.City;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface CityService {
    List<City> queryAll();

    void add(City city);
}
