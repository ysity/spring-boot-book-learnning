package org.sang.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class MyInterceptorl implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response , Object handle){
        System.out.println("MyInterceptorl>>>preHandle");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handle, ModelAndView modelAndView){
        System.out.println("MyInterceptorl>>>postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest request,HttpServletResponse response,
                                Object handle,Exception e){
        System.out.println("MyInterceptorl>>>afterCompletion");
    }
}
