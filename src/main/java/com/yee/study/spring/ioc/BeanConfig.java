package com.yee.study.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Author: RogerYee
 *
 * 采用Java-based container configuration
 *
 * 配置了Bean － myService
 */
@Configuration
@PropertySource("classpath:com/yee/study/spring/ioc/ioc.properties")
public class BeanConfig
{
    static Logger logger = LoggerFactory.getLogger(BeanConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public MyServiceImpl myService()
    {
        logger.debug("Property myBeanName = " + env.getProperty("myBeanName"));
        return new MyServiceImpl();
    }
}

class MyServiceImpl
{
    static Logger logger = LoggerFactory.getLogger(MyServiceImpl.class);

    public void doService()
    {
        logger.debug("doService() is invoked.");
    }
}

@Component
class OtherServiceImpl
{
    static Logger logger = LoggerFactory.getLogger(OtherServiceImpl.class);

    public void doService()
    {
        logger.debug("doService() is invoked.");
    }
}
