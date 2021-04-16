package com.csw.service;

import com.csw.dao.InfoDao;
import com.csw.entity.Infos;
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
public class InfoServiceImpl implements InfoService {
    @Autowired
    private InfoDao infoDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Infos> queryAll() {
        return infoDao.queryAll();
    }

    @Override
    public List<Infos> queryAll3() {
        return infoDao.queryAll3();
    }

    @Override
    public List<Infos> queryAll5() {
        return infoDao.queryAll5();
    }

    @Override
    public Infos queryAll5id(Integer id) {
        return infoDao.queryAll5id(id);
    }

    @Override
    public void delete(Integer id) {
        infoDao.delete(id);
    }

    @Override
    public void insert(Infos infos) {
        infoDao.insert(infos);
    }

    @Override
    public void update(Infos infos) {
        infoDao.update(infos);
    }


    @Override
    public List<Infos> query2(String tag, String into) {
        return infoDao.query2(tag,into);
    }

}
