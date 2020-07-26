package com.lanshiqin.start.core.exception;

/**
 * 业务异常
 *
 * @author 蓝士钦
 */
public class BusinessException extends RuntimeException {

    private Integer resultCode;

    public BusinessException(final Integer resultCode, final String resultMsg) {
        super(resultMsg);
        this.resultCode = resultCode;
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
