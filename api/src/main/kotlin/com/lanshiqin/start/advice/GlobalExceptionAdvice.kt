package com.lanshiqin.start.advice

import com.lanshiqin.start.core.base.BaseResponse
import com.lanshiqin.start.core.constant.ResultCodeEnum
import com.lanshiqin.start.core.exception.BusinessException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 全局异常处理
 * @author 蓝士钦
 */
@RestControllerAdvice
class GlobalExceptionAdvice {

    private val logger: Logger = LoggerFactory.getLogger(GlobalExceptionAdvice::class.java)

    @ExceptionHandler(Exception::class)
    fun exception(exception: Exception): BaseResponse<String> {
        logger.error("系统异常: ${exception.message}", exception)
        return BaseResponse.response(ResultCodeEnum.SYSTEM_EXCEPTION.code, "系统异常", "${exception.message}")
    }

    @ExceptionHandler(BusinessException::class)
    fun baseException(businessException: BusinessException): BaseResponse<String> {
        logger.info("业务异常:${businessException.message}", businessException)
        return BaseResponse.fail("${businessException.message}")
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentNotValidException(exception: MethodArgumentNotValidException): BaseResponse<String> {
        logger.info("业务异常:${exception.message}", exception)
        return BaseResponse.fail(exception.bindingResult.allErrors[0].defaultMessage)
    }
}