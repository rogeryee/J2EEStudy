package com.yee.study.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: RogerYee
 * <p/>
 * 调用src/sample-beans.xml生成对象
 */
public class SampleBeanClient
{
    public static void main(String[] args)
    {
        // 通过加载Classpath下的sample-bean.xml；
        // 下面两种方式都可以，一种写全XML的路径；
        // 另一种可以传递一个类给ApplicationContext，这样Spring会根据这个类所在的路径加载XML
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext(new String[]{"classpath:com/yee/study/spring/ioc/spring-ioc.xml"});
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"spring-ioc.xml"}, SampleBeanClient.class);

        // 1. 用SampleBean的默认构造器来生成SampleBean
        SampleBean sampleBean1 = context.getBean("sampleBeanByConstructor", SampleBean.class);
        sampleBean1.sayHello();

        // 2. 用SampleBeanFactory中的静态方法createSampleBean来生成Bean
        SampleBean sampleBean2 = (SampleBean)context.getBean("sampleBeanByStaticFactoryMethod");
        sampleBean2.sayHello();

        // 3. 用SampleBeanFactory中的非静态方法createSampleBeanInstance来生成Bean
        SampleBean sampleBean3 = (SampleBean)context.getBean("sampleBeanByFactoryMethod");
        sampleBean3.sayHello();

    }
}
