package com.yee.study.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * User: Roger.Yee
 * 一个最基础的使用JUnit4的例子
 */
public class CalculatorTest
{
    Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    private static Calculator calculator = new Calculator();

    @Before
    public void setUp() throws Exception
    {
        logger.debug("CalculatorTest starts");
        calculator.clear();
    }

    @After
    public void tearDown() throws Exception
    {
        logger.debug("CalculatorTest ends");
    }

    @Test
    public void testAdd()
    {
        calculator.add(2);
        calculator.add(3);
        assertEquals(5, calculator.getResult());
    }

    @Test
    public void testSubstract()
    {
        calculator.add(10);
        calculator.substract(2);
        assertEquals(8, calculator.getResult());
    }

    @Ignore("Multiply() Not yet implemented")
    @Test
    public void testMultiply()
    {

    }

    @Test
    public void testDivide()
    {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4, calculator.getResult());
    }

    @Test(timeout = 1000)
    public void squareRoot()
    {
        calculator.squareRoot(4);
        assertEquals(2, calculator.getResult());
    }
}

/**
 * 简单实现加减乘除、平方、开方的计算器类
 */
class Calculator
{
    private static int result; // 静态变量，用于存储运行结果

    public void add(int n)
    {
        result = result + n;
    }

    public void substract(int n)
    {
        //Bug: 正确的应该是 result =result-n
        result = result - 1;
    }

    public void multiply(int n)
    {
        // 此方法尚未写好
    }

    public void divide(int n)
    {
        result = result / n;
    }

    public void square(int n)
    {
        result = n * n;
    }

    public void squareRoot(int n)
    {
        for (; ; ) ;            //Bug : 死循环
    }

    public void clear()
    {
        // 将结果清零
        result = 0;
    }

    public int getResult()
    {
        return result;
    }
}