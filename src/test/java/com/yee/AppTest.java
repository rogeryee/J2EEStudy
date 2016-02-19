package com.yee;

import com.yee.study.cf.EuclideanFilter;
import org.junit.Test;

/**
 * Author: RogerYee
 */
public class AppTest
{
    @Test
    public void testGetApp()
    {
        System.out.println("test app");

        EuclideanFilter euclideanFilter = new EuclideanFilter();
        euclideanFilter.main(null);

        System.out.println("test app ends");

        String abc = "123456789";
        System.out.println(abc.substring(abc.length() - 4, abc.length()));
    }
}
