package com.lhb.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author harryper
 * @date 2020/8/15
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String date = "2020-08-32";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(simpleDateFormat.format(simpleDateFormat.parse(date)));
    }
}
