package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;

/**
 * 业务异常
 *
 * @author 蓝士钦
 */
public class BusinessException extends RuntimeException {

    private Integer resultCode;

    public BusinessException(final String resultMsg) {
        super(resultMsg);
        this.resultCode = ResultCodeEnum.BUSINESS_EXCEPTION.getCode();
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
