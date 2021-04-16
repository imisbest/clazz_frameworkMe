package com.csw.service;

import com.csw.dao.CityDao;
import com.csw.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<City> queryAll() {
        return cityDao.queryAll();
    }

    @Override
    public void add(City city) {
        cityDao.add(city);
    }
}
