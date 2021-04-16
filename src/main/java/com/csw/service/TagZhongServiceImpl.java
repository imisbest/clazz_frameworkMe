package com.csw.service;

import com.csw.dao.TagZhongDao;
import com.csw.entity.TagZhong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2019/10/29.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TagZhongServiceImpl implements TagZhongService {
    @Autowired
    private TagZhongDao tagZhongDao;

    @Override
    public void add(TagZhong tagZhong) {
        tagZhongDao.add(tagZhong);
    }

    @Override
    public void delete(Integer id) {
        tagZhongDao.delete(id);
    }
}
