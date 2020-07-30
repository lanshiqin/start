package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;

/**
 * 系统异常
 *
 * @author 蓝士钦
 */
public class SystemException extends RuntimeException {

    private Integer resultCode;

    public SystemException(final String resultMsg) {
        super(resultMsg);
        this.resultCode = ResultCodeEnum.SYSTEM_EXCEPTION.getCode();
    }

    public Integer getResultCode() {
        return resultCode;
    }
}
