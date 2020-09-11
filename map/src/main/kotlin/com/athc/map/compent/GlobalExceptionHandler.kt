package com.athc.map.compent

import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.*
import java.lang.RuntimeException

/**
 * @author jjj
 * @date 2020/9/11
 * @since JDK1.8
 */
@RestControllerAdvice
class GlobalExceptionHandler {
//
//  @InitBinder
//  fun handleInitBinder(binder: WebDataBinder) {
//    binder
//  }

  @ExceptionHandler(BindException::class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  fun handleBindException(exception: BindException): String? {
    return "Param exception"
  }

  @ExceptionHandler(Exception::class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun handleException(exception: RuntimeException): String? {
    return "system exception"
  }
}