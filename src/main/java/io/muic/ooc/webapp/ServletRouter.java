package io.muic.ooc.webapp;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

public class ServletRouter {
    private static final List<Class<? extends AbstractRoutableHttpServlet>> servletClasses = new ArrayList<>();

    static{
        servletClasses.add(HomeServlet.class);
        servletClasses.add(LoginServlet.class);
        servletClasses.add(LogoutServlet.class);
    }

    public void init(Context ctx){

        for (Class<? extends AbstractRoutableHttpServlet> servletClass:servletClasses) {
            try {
                AbstractRoutableHttpServlet httpServlet = servletClass.newInstance();
                Tomcat.addServlet(ctx, servletClass.getSimpleName(), httpServlet);
                // TRICK: mapping with index.jsp, allow access to root path "/"
                ctx.addServletMapping(httpServlet.getPattern(), servletClass.getSimpleName());

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
