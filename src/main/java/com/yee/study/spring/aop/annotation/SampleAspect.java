package com.yee.study.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * User: RogerYee
 * <p/>
 * 测试用的Aspect
 */
@Component
@Aspect
public class SampleAspect
{
    static Logger logger = LoggerFactory.getLogger(SampleAspect.class);

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
    @Pointcut("execution(* sayHi*(..))")
    public void pointcutSayHi()
    {
    }

    /**
     * 在以“sayHello”开头的方法执行之前调用本方法
     */
    @Before("pointcutSayHello()")
    public void doBefore()
    {
        logger.debug("doBefore()");
    }

    /**
     * 在以“sayHello”开头的方法执行之前调用本方法,
     * 此方法将匹配上sayHello(String, String, int, int)方法，并且和lastName以及age2匹配成功
     */
    @Before("pointcutSayHello() && args(lname,..,age)")
    public void doBefore(String lname, int age)
    {
        logger.debug("doBefore(String lname, int age) : lname = " + lname + ", age = " + age);
    }

    /**
     * 在以“sayHello”开头的方法执行之后调用本方法
     */
    @AfterReturning("pointcutSayHello()")
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
    @AfterReturning(pointcut = "pointcutSayHello()", returning = "ret")
    public void doAfterReturningWithReturning(JoinPoint jp, Object ret)
    {
        logger.debug("doAfterReturningWithReturning:jp = " + jp.toString());
        logger.debug("doAfterReturningWithReturning:ret = " + ret);
    }

    /**
     * 在以“sayHello”开头的方法执行之后调用本方法
     */
    @After("pointcutSayHello()")
    public void doAfter()
    {
        logger.debug("doAfter()");
    }

    /**
     * 在以“sayHi”开头的方法抛出异常之后调用本方法;
     *
     * @param ex
     */
    @AfterThrowing(pointcut = "pointcutSayHi()", throwing = "ex")
    public void doAfterThrowing(Exception ex)
    {
        logger.debug("doAfterThrowing() : exception = " + ex.getMessage());
    }

    @Around("pointcutSayHello()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable
    {
        logger.debug("doAround() before");
        Object ret = pjp.proceed();
        logger.debug("doAround() after");
        return ret;
    }
}
