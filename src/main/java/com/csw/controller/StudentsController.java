package com.csw.controller;

import com.csw.entity.*;
import com.csw.service.*;
import com.csw.util.Number;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/10/28.
 */
@Controller
@RequestMapping("student")
public class StudentsController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private XiaozService xiaozService;
    @Autowired
    private ClazzService clazzService;
    @Autowired
    private CityService cityService;
    @Autowired
    private TagService tagService;
    @Autowired
    private TagZhongService tagZhongService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        List<Infos> infosList = infoService.queryAll5();
        request.setAttribute("infosList", infosList);
        return "/back/student/index";
    }


    @RequestMapping("query2")
    public String query2(String tag,String into,HttpServletRequest request) {
        System.out.println("tag;;"+tag);
        System.out.println("into;;"+into);
        List<Infos> infosList=infoService.query2(tag,into);
        for (Infos infos : infosList) {
            System.out.println("query2 infosList;;"+infosList);
        }
        request.setAttribute("infosList", infosList);
        return "/back/student/index";
    }

    //下载所有学生信息
   @RequestMapping("download2")
    public void downloadInfo(String tag,String into, HttpServletResponse response) throws IOException {
        List<Infos> infosList = infoService.query2(tag, into);
        StringBuilder sb = new StringBuilder();
        infosList.forEach(student -> {
            sb.append(student.toString()).append("\n");
        });
        //设置响应类型
        response.setContentType("text/plain;charset=UTF-8");
        //通过响应流响应
        response.setHeader("content-disposition", "attachment;fileName=student.txt");
        response.getWriter().print(sb.toString());
    }

    @RequestMapping("detail")
    public String detail(Integer id, HttpServletRequest request) {
        System.out.println("id//:" + id);
        Infos infos = infoService.queryAll5id(id);
        System.out.println("infos//:" + infos);
        request.setAttribute("infos", infos);
        return "/back/student/detail";
    }

    @RequestMapping("updatefirst")
    public String updatefirst(Integer id, HttpServletRequest request) {
        System.out.println("id//:" + id);
        Infos infos = infoService.queryAll5id(id);
        System.out.println("infos;;" + infos);
        request.setAttribute("infos", infos);
        List<City> cityList = cityService.queryAll();
        cityList.forEach(city -> System.out.println("cityList;;" + city));
        request.setAttribute("cityList", cityList);
        List<Taglib> taglibList = tagService.queryByS();
        request.setAttribute("taglibList", taglibList);
        return "/back/student/update";
    }

    @RequestMapping("update")
    public String update(String[] stringList, Infos infos) {
        for (String s : stringList) {
            System.out.println(s);
        }
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        Date da = infos.getBir();
        String aa = com.csw.util.Year.getYear(Integer.parseInt(sf.format(da).substring(0, 4)));
        infos.setShengx(aa);
        infos.setXingz(com.csw.util.Year.getConstellation(da.getMonth() + 1, da.getDate()));

        System.out.println("infos//:" + infos);
        infoService.update(infos);
        /**
         *
         */
        tagZhongService.delete(infos.getId());
        List<String> strings = Arrays.asList(stringList);
        for (String string : strings) {
            TagZhong tagZhong = new TagZhong(null, Integer.parseInt(string), infos.getId(), null, null);
            tagZhongService.add(tagZhong);
        }
        return "redirect:/student/queryAll";
    }

    @RequestMapping("delete")
    public String delete(Integer id) {
        infoService.delete(id);
        return "redirect:/student/queryAll";
    }

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

    @RequestMapping("addfirst")
    public String addfirst(HttpServletRequest request) {
        List<City> cityList = cityService.queryAll();
        request.setAttribute("cityList", cityList);
        List<Taglib> taglibList = tagService.queryByS();
        request.setAttribute("taglibList", taglibList);
        return "/back/student/add";
    }

    @RequestMapping("add")
    public String add(String[] stringList, Infos infos) {
        for (String s : stringList) {
            System.out.println(s);
        }
        System.out.println("infos//:" + infos);
        /**
         *更新学生对象，插入生肖和星座
         */
        String num = Number.getNum();
        Integer id = Integer.parseInt(num);
        infos.setId(id);
        infos.setBeiz(infos.getBeiz().trim());
        /**/
        SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
        Date da = infos.getBir();
        String aa = com.csw.util.Year.getYear(Integer.parseInt(sf.format(da).substring(0, 4)));
        infos.setShengx(aa);
        infos.setXingz(com.csw.util.Year.getConstellation(da.getMonth() + 1, da.getDate()));
        System.out.println("infos//:" + infos);
        infoService.insert(infos);
        /**
         *更新中间表
         */
        List<String> strings = Arrays.asList(stringList);
        for (String string : strings) {
            TagZhong tagZhong = new TagZhong(null, Integer.parseInt(string), id, null, null);
            tagZhongService.add(tagZhong);
        }
        return "redirect:/student/queryAll";
    }
}
