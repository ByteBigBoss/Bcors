package com.bytebigboss.bcors;

import java.util.Arrays;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author ByteBigBoss
 */
public class CorsListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //SET CORS CONFIGURATIONS GLOBALLY WHEN APPLICATION STATS
        Bcors corsContext = Bcors.getInstance();
        corsContext.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        corsContext.setAllowedMethods(Arrays.asList("POST", "GET", "OPTIONS"));
        System.out.println("CorsListener Activated.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //CLEAN UP CODE
    }
}
