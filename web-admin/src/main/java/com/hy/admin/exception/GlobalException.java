package com.hy.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/13 15:52
 */

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    public String handleArithException(Exception e){
        log.error("异常是：{}",e);
        return "login";
    }

}
