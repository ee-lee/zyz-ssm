package com.yc.util;

import com.yc.pojo.Root;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 简单的拦截器
 * LOGIN_URL 放行地址
 * 根据session有没有root判断有没有登录
 **/

public class MyInterceptor implements HandlerInterceptor {
    private static final String LOGIN_URL = "/page/admin/login.html";
    private static final String LOGIN_URL2 = "/page/admin/jd/login.html";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

        HttpSession session = request.getSession();

        Root root = (Root) session.getAttribute("root");

        if ((root == null || "".equals(root.toString())  )  ) {
            response.setCharacterEncoding("UTF-8");
            System.out.println(request.getContextPath() + LOGIN_URL);
            response.sendRedirect(request.getContextPath() + LOGIN_URL);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
