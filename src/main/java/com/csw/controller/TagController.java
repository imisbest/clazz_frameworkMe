package com.csw.controller;

import com.csw.entity.Taglib;
import com.csw.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
@Controller
@RequestMapping("tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        List<Taglib> taglibs = tagService.queryAll();
        request.setAttribute("taglibs", taglibs);
        return "/back/tag/index";
    }

    @RequestMapping("add")
    public String add(Taglib taglib) {
        taglib.setId(null);
        taglib.setDd(new Date());
        tagService.add(taglib);
        return "redirect:/tag/queryAll";
    }
}
