package com.csw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/10/29.
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Component
public class TagZhong implements Serializable {
    private Integer id;
    private Integer bid;
    private Integer iid;
    private Infos infos;
    private Taglib taglib;
}
