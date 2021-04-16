package com.csw.controller;

import com.csw.entity.Clazz;
import com.csw.entity.Xiaoz;
import com.csw.service.ClazzService;
import com.csw.service.XiaozService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by HIAPAD on 2019/10/16.
 */
@Controller
@RequestMapping("c")
public class City2Cotroller {
    @Autowired
    private XiaozService xiaozService;
    @Autowired
    private ClazzService clazzService;

    @RequestMapping("findCity")
    public String findCity(Integer parentId, HttpServletResponse response) throws IOException {
        /**
         * id是班级id
         */
        List<Xiaoz> xiaozList = xiaozService.findBy(parentId);
        // 将cities转换成json字符串
        Gson gson = new Gson();
        String json = gson.toJson(xiaozList);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(json);
        return null;
    }

    @RequestMapping("findName")
    public String queryAll(String name, HttpServletResponse response) throws IOException {
        System.out.println("name:" + name);
        /**
         * 通过班级名字模糊查询
         */
        List<Clazz> clazzList = clazzService.queryAllByName(name);
        Gson gson = new Gson();
        String sss = gson.toJson(clazzList);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.print(sss);
        return null;
    }
}
