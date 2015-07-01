package com.yee.study.spring.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Author: RogerYee
 *
 * 用Annotation的方式启用AspectJ，
 * "@EnableAspectJAutoProxy"也可以通过在配置文件中添加 <aop:aspectj-autoproxy/>来启用
 */
@Configuration
@ComponentScan(basePackages = "com.yee.study.spring.aop")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopConfig
{
}
