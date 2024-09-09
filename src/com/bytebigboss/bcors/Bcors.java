package com.bytebigboss.bcors;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author ByteBigBoss
 */
public class Bcors {

    private static Bcors instance;
    private List<String> allowedOrigins;
    private List<String> allowedMethods;
    private String allowedHeaders = "Content-Type, Authorization";
    private String allowCredentials = "true";

    //DEFAULT CONFIGURATIONS
    private static final List<String> defaultOrigins = Arrays.asList("http://localhost:3000");
    private static final List<String> defaultMethods = Arrays.asList("POST", "GET", "OPTIONS");

    private Bcors(List<String> allowedOrigins, List<String> allowedMethods) {
        this.allowedOrigins = allowedOrigins;
        this.allowedMethods = allowedMethods;
    }

    public static Bcors getInstance(List<String> allowedOrigins, List<String> allowedMethods) {
        if (instance == null) {
            instance = new Bcors(allowedOrigins, allowedMethods);
        }
        return instance;
    }

    public static Bcors getInstance() {
        if (instance == null) {
            instance = new Bcors(defaultOrigins, defaultMethods);
        }
        return instance;
    }

    //CORES SETTER
    public static void setCors(HttpServletRequest req, HttpServletResponse res) {
        Bcors corsFactory = Bcors.getInstance();
        corsFactory.setCORSHeaders(req, res);
    }

    public void setCORSHeaders(HttpServletRequest req, HttpServletResponse res) {
        String origin = req.getHeader("Origin");
        if (this.getAllowedOrigins().contains(origin)) {
            res.setHeader("Access-Control-Allow-Origin", origin);
        } else {
            res.setHeader("Access-Control-Allow-Origin", "");
        }
        res.setHeader("Access-Control-Allow-Methods", String.join(", ", this.getAllowedMethods()));
        res.setHeader("Access-Control-Allow-Headers", this.getAllowedHeaders());
        res.setHeader("Access-Control-Allow-Credentials", this.getAllowCredentials());
    }

    public List<String> getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(List<String> allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public List<String> getAllowedMethods() {
        return allowedMethods;
    }

    public void setAllowedMethods(List<String> allowedMethods) {
        this.allowedMethods = allowedMethods;
    }

    public String getAllowedHeaders() {
        return allowedHeaders;
    }

    public void setAllowedHeaders(String allowedHeaders) {
        this.allowedHeaders = allowedHeaders;
    }

    public String getAllowCredentials() {
        return allowCredentials;
    }

    public void setAllowCredentials(String allowCredentials) {
        this.allowCredentials = allowCredentials;
    }
}
