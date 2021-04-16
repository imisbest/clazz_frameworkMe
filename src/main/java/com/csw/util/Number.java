package com.csw.util;

import java.util.Random;

public class Number {

    //给定一个字符串
    static String str = "0123456789";

    public static String getNum() {
        StringBuffer salt = new StringBuffer();
        for (int i = 0; i < 5; i++) {
            salt.append(str.charAt(new Random().nextInt(10)));
        }
        return salt.toString();
    }

}

