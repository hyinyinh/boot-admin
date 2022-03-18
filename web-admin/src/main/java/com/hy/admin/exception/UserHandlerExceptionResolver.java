package com.hy.admin.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/13 16:20
 */

//@Order(value = Ordered.HIGHEST_PRECEDENCE) //优先级
//@Component
public class UserHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            response.sendError(555,"姜鹏宇是大傻子");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
