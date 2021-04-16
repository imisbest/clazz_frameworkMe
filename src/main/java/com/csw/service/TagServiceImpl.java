package com.csw.service;

import com.csw.dao.TagDao;
import com.csw.entity.Taglib;
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
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public List<Taglib> queryAll() {
        return tagDao.queryAll();
    }

    @Override
    public void add(Taglib taglib) {
        tagDao.add(taglib);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Taglib> queryByC() {
        return tagDao.queryByC();
    }

    @Override
    public List<Taglib> queryByS() {
        return tagDao.queryByS();
    }
}
