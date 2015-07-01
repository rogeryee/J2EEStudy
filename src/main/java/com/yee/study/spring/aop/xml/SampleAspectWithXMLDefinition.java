package com.yee.study.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: RogerYee
 * <p/>
 * 测试用的Aspect
 */
public class SampleAspectWithXMLDefinition
{
    static Logger logger = LoggerFactory.getLogger(SampleAspectWithXMLDefinition.class);

    /**
     * 匹配任何以“sayHello”开头的方法
     */
    @Pointcut("execution(* sayHello*(..))")
    public void pointcutSayHello()
    {
    }

    /**
     * 匹配任何以“sayHi”开头的方法
     */
    public void pointcutSayHi()
    {
    }

    /**
     * 在以“sayHello”开头的方法执行之前调用本方法
     */
    public void doBefore()
    {
        logger.debug("doBefore()");
    }

    /**
     * 在以“sayHello”开头的方法执行之前调用本方法,
     * 此方法将匹配上sayHello(String, String, int, int)方法，并且和lastName以及age2匹配成功
     */
    public void doBeforeWithArgs(String lname, int age)
    {
        logger.debug("doBeforeWithArgs(String lname, int age) : lname = " + lname + ", age = " + age);
    }

    /**
     * 在以“sayHello”开头的方法执行之后调用本方法
     */
    public void doAfterReturning()
    {
        logger.debug("doAfterReturning");
    }

    /**
     * 在以“sayHello”开头的方法执行之后调用本方法;
     * 并获取那些以“sayHello”开头的方法的返回值
     *
     * @param jp
     * @param ret
     */
    public void doAfterReturningWithReturning(JoinPoint jp, Object ret)
    {
        logger.debug("doAfterReturningWithReturning:jp = " + jp.toString());
        logger.debug("doAfterReturningWithReturning:ret = " + ret);
    }

    /**
     * 在以“sayHello”开头的方法执行之后调用本方法
     */
    public void doAfter()
    {
        logger.debug("doAfter()");
    }

    /**
     * 在以“sayHi”开头的方法抛出异常之后调用本方法;
     *
     * @param ex
     */
    public void doAfterThrowing(Exception ex)
    {
        logger.debug("doAfterThrowing() : exception = " + ex.getMessage());
    }

    public Object doAround(ProceedingJoinPoint pjp) throws Throwable
    {
        logger.debug("doAround() before");
        Object ret = pjp.proceed();
        logger.debug("doAround() after");
        return ret;
    }
}
