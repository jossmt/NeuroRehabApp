package com.app.neurorehab.controller.security.filters;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class RequestInterceptorFilter extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestInterceptorFilter.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) {

//        try {
//            LOG.debug("Rest Request: {}", IOUtils.toString(request.getReader()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return true;
    }

}
