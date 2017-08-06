package cn.itcast.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor implements HandlerInterceptor{

    /**
     * 前置方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("========= MyHandlerInterceptor的  preHandle 执行 ===========");
        return true;//继续执行后续逻辑
    }

    /**
     * 后置方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("========= MyHandlerInterceptor的  postHandle 执行 ===========");
    }

    /**
     * 完成方法
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) throws Exception {
        System.out.println("========= MyHandlerInterceptor的  afterCompletion 执行 ===========");
    }

}
