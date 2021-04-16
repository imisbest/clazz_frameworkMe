package com.csw.controller;

import com.csw.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2019/10/28.
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("login")
    public String LoginAction(User user, String captchaCode, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("securityCode");
        System.out.println("code:" + code);
        System.out.println("captchaCode//:" + captchaCode);
        System.out.println("code.equals(captchaCode)://" + code.equals(captchaCode));
        User user1 = new User("qqq", "qqq");
        User user2 = new User("admin", "admin");
        if (user1.equals(user) && code.equalsIgnoreCase(captchaCode)) {
            session.setAttribute("user", user1);
            return "redirect:/back/main/main.jsp";
        } else if (user2.equals(user) && code.equals(captchaCode)) {
            session.setAttribute("user", user2);
            return "redirect:/back/main/main.jsp";
        } else {
            return "redirect:/back/login.jsp";
        }
    }
}
