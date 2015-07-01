package com.yee.study.corejava.core;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 7/18/14
 * Time: 2:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateTest
{
    public static void main(String args[])
    {
        DateTest test = new DateTest();
        test.getSystemCurrentTime();
        test.getCurrentDate();
    }

    /**
     * 获取系统当前时间
     * System.currentTimeMillis()返回系统当前时间，结果为1970年1月1日0时0分0秒开始，到程序执行取得系统时间为止所经过的毫秒数
     * 1秒＝1000毫秒
     */
    public void getSystemCurrentTime()
    {
        System.out.println("----获取系统当前时间----");
        System.out.printf("系统当前时间 = %s \n", System.currentTimeMillis());
    }

    /**
     * 通过Date类获取当前日期和当前时间
     * date.toString()把日期转换为dow mon dd hh:mm:ss zzz yyyy
     */
    public void getCurrentDate()
    {
        System.out.println("----获取系统当前日期----");
        //创建并初始化一个日期（初始值为当前日期）
        Date date = new Date();
        System.out.println("现在的日期是 = " + date.toString());
        System.out.println("自1970年1月1日0时0分0秒开始至今所经历的毫秒数 = " + date.getTime());
    }
}
