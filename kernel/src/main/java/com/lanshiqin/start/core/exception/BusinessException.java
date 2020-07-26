package com.lanshiqin.start.core.exception;

/**
 * 业务异常
 * @author 蓝士钦
 */
public class BusinessException extends RuntimeException{

    public BusinessException(Integer resultCode,String resultMsg) {
        super(resultMsg);
    }
}
