package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Infos implements Serializable {
    private Integer id;// int(3) auto_increment primary key,
    private String name;// VARCHAR(11),
    private String age;// VARCHAR(11),
    private Date bir;// TIMESTAMP,
    private String phone;// varchar(22),
    private String qq;// varchar(22),
    private String shengx;// VARCHAR(11),
    private String xingz;// varchar(11),
    private String beiz;// varchar(99),
    private Integer tid;// varchar(11),
    private Integer cid;// int(11),
    private Integer xid;// int(11),
    private Integer bid;// int(11)
    private Clazz clazz;
    private Xiaoz xiaoz;
    private City city;
    private TagZhong tagz;
    /**
     * 多对多使用
     */
    private List<Taglib> taglibs;//

}
