package com.bf.studysb.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ApiException.class)
    @ResponseBody
    public ExceptionResultBody ApiExceptionHandler(HttpServletRequest req, ApiException e){
        logger.error("发生业务异常！原因是：{}",e.getErrorMsg());
        return ExceptionResultBody.error(e.getErrorCode(),e.getErrorMsg());
    }

    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public ExceptionResultBody exceptionHandler(HttpServletRequest req, NullPointerException e){
        logger.error("发生空指针异常！原因是:",e);
        return ExceptionResultBody.error(CommonEnum.BODY_NOT_MATCH);
    }


    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public ExceptionResultBody exceptionHandler(HttpServletRequest req, Exception e){
        logger.error("未知异常！原因是:",e);
        return ExceptionResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }

}
