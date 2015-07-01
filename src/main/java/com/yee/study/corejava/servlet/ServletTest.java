package com.yee.study.corejava.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: Roger.Yee
 */
public class ServletTest extends HttpServlet
{
    static final Logger logger = LoggerFactory.getLogger(ServletTest.class);

    private String contextParams;
    private String servletInitParams;

    public void init(ServletConfig config) throws ServletException
    {
        logger.debug("ServletTest is initialized.");
        super.init(config);

        // Same as using this.getServletContext().getInitParameter("ContextParams")
        this.contextParams = config.getServletContext().getInitParameter("ContextParams");

        // Same as using this.getInitParameter("ServletInitParams")
        this.servletInitParams = config.getInitParameter("ServletInitParams");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        logger.debug("ServletTest is working.");

        response.setContentType("text/html; charset=GB2312");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>ServletTest</title></head>");
        out.println("<body>");
        out.println("<h2>It's ServletTest</h2><br/>");
        out.println("ContextParams : " + this.contextParams + "<br/><br/>");
        out.println("ServletInitParams : " + this.servletInitParams + "<br/>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public String getServletInfo()
    {
        return "com.yee.study.corejava.core.ServletTest";
    }
}
