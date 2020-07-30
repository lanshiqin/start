package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;

/**
 * 未授权异常
 *
 * @author 蓝士钦
 */
public class UnAuthException extends RuntimeException {

    private Integer resultCode;

    public UnAuthException(final String resultMsg) {
        super(resultMsg);
        this.resultCode = ResultCodeEnum.UN_AUTH_EXCEPTION.getCode();
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
