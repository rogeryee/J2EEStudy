package com.yee.study;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 6/27/14
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test
{

    public static void main(String[] args)
    {
        BigDecimal number = new BigDecimal(0.00050);

        System.out.println(percentage(number.doubleValue(), 2));
    }

    public static String percentage(double num, int scale)
    {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracy_num = num * 100;
        return df.format(accuracy_num) + "%";
    }
}

