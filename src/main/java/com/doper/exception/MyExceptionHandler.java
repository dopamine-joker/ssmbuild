package com.doper.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//使用该注解，所有控制器抛出的异常都由这里处理
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(sqlBookException.class)
    public String sqlBookExceptionHandler() {
        return "error";
    }
}
