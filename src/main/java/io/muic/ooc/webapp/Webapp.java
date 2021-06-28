package io.muic.ooc.webapp;

import java.io.File;
import javax.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Webapp {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        File docBase = new File("src/main/webapp/");
        docBase.mkdirs();

        try {
            Context ctx = tomcat.addWebapp("", docBase.getAbsolutePath());

            HomeServlet homeServlet = new HomeServlet();
            Tomcat.addServlet(ctx, HomeServlet.class.getSimpleName() , homeServlet);
            // TRICK: mapping with index.jsp, allow access to root path "/"
            ctx.addServletMapping("/index.jsp", HomeServlet.class.getSimpleName());

            LoginServlet loginServlet = new LoginServlet();
            Tomcat.addServlet(ctx, LoginServlet.class.getSimpleName(), loginServlet);
            ctx.addServletMapping("/login", LoginServlet.class.getSimpleName());


            tomcat.start();
            tomcat.getServer().await();
        } catch (ServletException e){
            e.printStackTrace();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

    }
}
