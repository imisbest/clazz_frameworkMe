package com.csw.controller;

import com.csw.util.SecurityCode;
import com.csw.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@Controller
@RequestMapping("captcha")
public class CaptchaAction {
    @RequestMapping("captcha")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // ������֤�������
        String securityCode = SecurityCode.getSecurityCode();
        /**
         * �����������session,δ����������֤
         */
        HttpSession session = request.getSession();
        session.setAttribute("securityCode", securityCode);

        // ����������֤��ͼƬ
        BufferedImage image = SecurityImage.createImage(securityCode);
        // ��Ӧ���ͻ���

        OutputStream out = response.getOutputStream();
        /**
         * ��һ�������� ָ����֤��ͼƬ���� �ڶ��������� ͼƬ�ĸ�ʽ ������������ ָ�������
         */
        ImageIO.write(image, "png", out);

        return null;// ����null��������ת
    }
}