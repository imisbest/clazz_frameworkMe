package com.csw.dao;

import com.csw.entity.Infos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
public interface InfoDao {
    List<Infos> queryAll();

    List<Infos> queryAll3();

    List<Infos> queryAll5();

    Infos queryAll5id(@Param("id") Integer id);

    void delete(@Param("id") Integer id);

    void insert(@Param("i") Infos infos);

    void update(@Param("i") Infos infos);

    List<Infos> queryByGroupId(String id);

    List<Infos> query2(@Param("t") String tag,
                       @Param("i") String into);
}
