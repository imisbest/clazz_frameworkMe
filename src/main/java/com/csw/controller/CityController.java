package com.csw.controller;

import com.csw.entity.City;
import com.csw.service.CityService;
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
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping("queryAll")
    public String queryAll(HttpServletRequest request) {
        List<City> cities = cityService.queryAll();
        request.setAttribute("cities", cities);

        List<City> cities1 = cityService.queryAll();
        request.setAttribute("cities1", cities1);

        List<City> cities2 = cityService.queryAll();
        request.setAttribute("cities2", cities);

        List<City> cities3 = cityService.queryAll();
        request.setAttribute("cities3", cities3);

        List<City> cities4 = cityService.queryAll();
        request.setAttribute("cities4", cities4);

        return "/back/city/index";
    }

    @RequestMapping("add")
    public String add(City city) {
        city.setId(null);
        city.setDd(new Date());
        cityService.add(city);
        return "redirect:/city/queryAll";
    }
}
