package co.com.david.guice;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import co.com.david.guice.web.GuiceContextListener;

import com.google.inject.servlet.GuiceFilter;

/**
 * Created by aurel.avramescu on 08/06/2014.
 */
@Slf4j
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8000);
        
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/app");
        handler.addFilter(GuiceFilter.class, "/*", EnumSet.allOf(DispatcherType.class));
        
        
        GuiceContextListener contextListener = new GuiceContextListener("demo-guice-boot");
        handler.addEventListener(contextListener);
        handler.addServlet(HttpServletDispatcher.class, "/*");
        
        
        System.out.println("Server Iniciado !!");

	    server.setHandler(handler);
	    server.start();
	    server.join();
    }
}
