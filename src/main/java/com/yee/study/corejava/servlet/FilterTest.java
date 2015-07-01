package com.yee.study.corejava.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * Author: RogerYee
 */
public class FilterTest implements Filter
{
    static final Logger logger = LoggerFactory.getLogger(FilterTest.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        logger.debug("Filter is initialized.");
        String encoding = filterConfig.getInitParameter("encoding");

        logger.debug("FilterTest.encoding : " + encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        logger.debug("Filter is working.");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy()
    {
        logger.debug("Filter is destroyed.");
    }
}
