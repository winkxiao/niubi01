package cn.xiaowei.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 时间对象转字符串
 *                  字符串转date
 * @author: winkxiao
 * @date: 2019/3/25 16:08
 */
public class dateUtils {

    /**
     * 功能描述:
     * 〈date对象按指定格式转字符串〉
     *
     * @param date 1
     * @param patt 2
     * @return : java.lang.String
     * @author : WinkXiao
     * @date : 2019/3/25 16:11
     *
     */
    public static String date2String(Date date,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    /**
     * 功能描述:
     * 〈解析字符串，为date对象〉
     *
     * @param patt 1
     * @return : java.util.Date
     * @author : WinkXiao
     * @date : 2019/3/25 16:13
     */
    public static Date string2date(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date pars = sdf.parse(str);
        System.out.println(pars);
        return pars;
    }
}
