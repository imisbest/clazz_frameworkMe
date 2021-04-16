package com.csw.controller;

import com.csw.entity.Clazz;
import com.csw.entity.Taglib;
import com.csw.service.ClazzService;
import com.csw.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
@Controller
@RequestMapping("clazz")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private TagService tagService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        List<Clazz> clazzList = clazzService.queryAll();
        System.out.println("queryAll" + clazzList);
        request.setAttribute("clazzList", clazzList);
        return "/back/clazz/index";
    }

    @RequestMapping("add")
    public String add(Clazz clazz) {
        clazz.setId(null);
        clazzService.add(clazz);
        System.out.println("add" + clazz);
        return "redirect:/clazz/queryAll";
    }

    @RequestMapping("addfirst")
    public String addfirst(HttpServletRequest request) {
        List<Taglib> taglibs = tagService.queryByC();
        System.out.println("addfirst" + taglibs);
        request.setAttribute("taglibs", taglibs);
        return "/back/clazz/add";
    }
}
