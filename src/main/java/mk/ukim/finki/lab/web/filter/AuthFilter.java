//package mk.ukim.finki.lab.web.filter;
//
//import jakarta.servlet.*;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "auth-filter", urlPatterns = "/*", dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
//public class AuthFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("AuthFilter initialized.");
//        Filter.super.init(filterConfig);
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
//            throws IOException, ServletException {
//
//        System.out.println("DoFilter metod.");
//
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//        String path = req.getServletPath();
//        System.out.println("Path: " + path);
//
//        filterChain.doFilter(servletRequest, servletResponse);
//
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("AuthFilter destroyed.");
//        Filter.super.destroy();
//    }
//}
