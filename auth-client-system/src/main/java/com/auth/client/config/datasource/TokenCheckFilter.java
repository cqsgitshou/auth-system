//package com.zimo.auth.config.datasource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
////@Component
////@Order(1)
//public class TokenCheckFilter implements Filter {
//
//    @Autowired
//    private CheckTokenEndpoint checkTokenEndpoint;
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("TokenCheckFilter");
//
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        String authorizationHeaderValue = request.getHeader("Authorization");
//
//        String token = authorizationHeaderValue.substring("Bearer ".length());
//        System.out.println(token);
//        checkTokenEndpoint.checkToken(token);
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//}