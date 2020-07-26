package com.lanshiqin.start.core.constant;

/**
 * 响应状态码枚举
 *
 * @author 蓝士钦
 */
public enum ResultCodeEnum {

    SUCCESS(2000, "操作成功"),
    SYSTEM_EXCEPTION(5000, "系统异常"),
    BUSINESS_EXCEPTION(4000, "业务异常");

    private final Integer code;
    private final String describe;

    public Integer getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }

    ResultCodeEnum(final Integer code, final String describe) {
        this.code = code;
        this.describe = describe;
    }
}
