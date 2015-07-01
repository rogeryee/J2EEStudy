package com.yee.study.corejava.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Author: RogerYee
 */
public class ListenerTest implements ServletContextListener
{
    static final Logger logger = LoggerFactory.getLogger(ListenerTest.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        logger.debug("ListenerTest is initialized.");

        String contextParams = servletContextEvent.getServletContext().getInitParameter("ContextParams");
        logger.debug("ContextParams : " + contextParams);

        logger.debug("serverInfo : " + servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        logger.debug("ListenerTest is destroyed.");
    }
}
