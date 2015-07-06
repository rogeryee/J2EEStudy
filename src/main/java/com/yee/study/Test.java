package com.yee.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Roger.Yee
 * Date: 6/27/14
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test
{
    static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String [] arg)
    {
        int x = 4;
        int y = 5;
        y = x++;

        logger.debug("y = {}", y);
    }
}

