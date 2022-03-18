package com.hy.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/13 16:04
 */

@ResponseStatus(value= HttpStatus.FORBIDDEN,reason="用户太多")
public class UserTwoManyException extends RuntimeException{
    public UserTwoManyException(){

    }

    public UserTwoManyException(String message){
        super(message);
    }
}
