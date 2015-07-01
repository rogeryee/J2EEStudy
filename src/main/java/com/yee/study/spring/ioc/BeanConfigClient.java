package com.yee.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Author: RogerYee
 *
 * 采用AnnotationConfigApplicationContext加载BeanConfig
 */
public class BeanConfigClient
{
    public static void main(String [] args)
    {
        // 加载使用了@Configuration和@Component注释的Bean
        // 如果在BeanConfig类上添加了@ComponentScan(basePackages = "com.yee.study.spring.ioc"),那么OtherServiceImpl会被自动加载
        // 就不需要做为参数传入ApplicationContext的构造函数中了。
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class, OtherServiceImpl.class);

        MyServiceImpl myService = context.getBean(MyServiceImpl.class);
        myService.doService();

        OtherServiceImpl otherService = context.getBean(OtherServiceImpl.class);
        otherService.doService();
    }
}
