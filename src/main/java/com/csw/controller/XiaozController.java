package com.csw.controller;

import com.csw.entity.Clazz;
import com.csw.entity.Xiaoz;
import com.csw.service.ClazzService;
import com.csw.service.InfoService;
import com.csw.service.XiaozService;
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
@RequestMapping("group")
public class XiaozController {
    @Autowired
    private XiaozService xiaozService;
    @Autowired
    private InfoService infoService;
    @Autowired
    private ClazzService clazzService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        /*  List<Infos> infosList = infoService.queryAll3();*/
        List<Xiaoz> xiaozList = xiaozService.queryAll2();
        request.setAttribute("xiaozList", xiaozList);
        System.out.println(xiaozList);
        return "/back/group/index";
    }

    @RequestMapping("addfirst2")
    public String addfirst(HttpServletRequest request) {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        List<Clazz> clazzList = clazzService.queryAll();
        System.out.println(clazzList);
        request.setAttribute("clazzList", clazzList);
        return "/back/group/add";
    }

    @RequestMapping("add")
    public String add(Xiaoz xiaoz) {
        xiaoz.setId(null);
        xiaoz.setDd(new Date());
        xiaozService.add(xiaoz);
        return "redirect:/group/queryAll";
    }

}
