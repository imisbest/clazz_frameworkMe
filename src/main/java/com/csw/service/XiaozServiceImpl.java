package com.csw.service;

import com.csw.dao.InfoDao;
import com.csw.dao.XaiozDao;
import com.csw.entity.Xiaoz;
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
public class XiaozServiceImpl implements XiaozService {
    @Autowired
    private XaiozDao xaiozDao;
    @Autowired
    private InfoDao infoDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Xiaoz> queryAll() {
        return xaiozDao.queryAll();
/*        List<Xiaoz> groups = xaiozDao.queryAll();
        //根据组获取每个组的所有学生信息
        for (Xiaoz group : groups) {
            //每次遍历组的时候创建一个新的map结构  以保证本次比较的结果准确
            Map<String, Integer> maps = new HashMap<String, Integer>(); //用来计数  学霸 1 帅哥3  美女 1   学渣 1
            //获取每个组中有多少学生
            List<Infos> students = infoDao.queryByGroupId(group.getId());
            //遍历每个学生的标签集合
            for (Infos student : students) {
                //获取每一个学生的标签集合
                List<Taglib> tags = student.getTaglibs();   //张三   学霸 1   帅哥 1   李四  美女 1  帅哥 2  王五 学渣 1 帅哥 3
                for (Taglib tag : tags) {
                    if (maps.get(tag.getName()) == null) {
                        maps.put(tag.getName(), 1);
                    } else {
                        maps.put(tag.getName(), (maps.get(tag.getName()) + 1));
                    }
                }
            }
            //当前组中学生数量与这个组的标签数量一致就为交集
            for (Map.Entry<String, Integer> entry : maps.entrySet()) {
                //如果标签个数 与 组内学生数量一致  一定是组标签交集
                if (entry.getValue().equals(students.size())) {
                    //entry.getKey();//标签名
                    System.out.println(entry.getKey());
                    //当前这个标签就是组的标签
                    group.getTag().add(entry.getKey());
                }
            }
        }
        return groups;*/

    }

    @Override
    public void add(Xiaoz xiaoz) {
        xaiozDao.add(xiaoz);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Xiaoz> queryAll2() {
        return xaiozDao.queryAll2();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Xiaoz> findBy(Integer parentId) {
        return xaiozDao.findBy(parentId);
    }
}
