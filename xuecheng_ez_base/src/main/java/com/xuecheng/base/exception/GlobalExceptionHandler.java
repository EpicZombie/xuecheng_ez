package com.xuecheng.base.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ControllerAdvice
//@RestControllerAdvice
public class GlobalExceptionHandler {

   //对项目的自定义异常进行处理
   @ResponseBody
   @ExceptionHandler(XueChengEzException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RestErrorResponse customException(XueChengEzException e) {
      log.error("【系统异常】{}",e.getMessage(),e);
      return new RestErrorResponse(e.getMessage());
   }

   //其他正常的系统异常
   @ResponseBody
   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RestErrorResponse exception(Exception e) {
      log.error("【系统异常】{}",e.getMessage(),e);
      return new RestErrorResponse(CommonError.UNKOWN_ERROR.getErrMessage());
   }

   //MethodArgumentNotValidException异常
   @ResponseBody
   @ExceptionHandler(MethodArgumentNotValidException.class)
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   public RestErrorResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {

      BindingResult bindingResult = e.getBindingResult();
      //存放错误信息
      List<String> errors = new ArrayList<>();
      bindingResult.getFieldErrors().stream().forEach(item -> {
         //拼接在一起 放出去
         errors.add(item.getDefaultMessage());
      });
      //把List中的错误信息拼接起来，
      String errMsg = StringUtils.join(errors, ",");//拼接list中的各个string，用 逗号 拼接
      log.error("【系统异常】{}",e.getMessage(),e);
      RestErrorResponse response = new RestErrorResponse(errMsg);
      return response;
   }
}