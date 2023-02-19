package com.tsmc.template.online.web.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.tsmc.template.common.vo.BaseVo;


@RestControllerAdvice(basePackages= {"com.tsmc.template.online.web.controller"})
public class GlobalExceptionHandler {
	
    @ExceptionHandler(value = { Exception.class })
    public BaseVo exceptionHandler(Exception e) {
        return new BaseVo(false,e.getMessage());
    }
}
