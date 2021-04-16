package com.csw.dao;

import com.csw.entity.TagZhong;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2019/10/29.
 */
public interface TagZhongDao {
    void add(@Param("t") TagZhong tagZhong);

    void delete(Integer id);
}
