package com.csw.service;

import com.csw.dao.ClazzDao;
import com.csw.entity.Clazz;
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
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzDao clazzDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Clazz> queryAll() {
        return clazzDao.queryAll();
    }

    @Override
    public void add(Clazz clazz) {
        clazzDao.add(clazz);
    }

    @Override
    public List<Clazz> queryAllByName(String name) {
        return clazzDao.queryAllByName(name);
    }
}
