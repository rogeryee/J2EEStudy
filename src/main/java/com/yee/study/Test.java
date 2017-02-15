package com.yee.study;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
        new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add(null);
        list.add("2");

        BigDecimal number = new BigDecimal(0.00050);

        System.out.println(percentage(number.doubleValue(), 2));

        TestObj obj = new TestObj();
        obj.setCount(1);

        int count = 1;
        obj.setCount(++count);
        System.out.println(obj.getCount());

        String companyTelNumber = "085128264681";
        companyTelNumber = companyTelNumber.replaceAll("[^\\d]", "");
        boolean matches = companyTelNumber.matches("\\d{11,}");
        System.out.println("matches : " + matches);
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

class TestObj
{
    private int count;

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
}

