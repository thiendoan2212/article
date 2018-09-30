package com.a97lynk.article.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ArticleInterceptor extends HandlerInterceptorAdapter {

    private static final Log logger = LogFactory.getLog(ArticleInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info(String.format("%s %s", request.getMethod(), request.getRequestURI()));
        return super.preHandle(request, response, handler);
    }
}
