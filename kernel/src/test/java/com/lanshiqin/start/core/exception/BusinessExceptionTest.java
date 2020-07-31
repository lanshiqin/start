package com.lanshiqin.start.core.exception;

import com.lanshiqin.start.core.constant.ResultCodeEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusinessExceptionTest {

    @Test
    public void testGetResultCode() {
        String message = ResultCodeEnum.BUSINESS_EXCEPTION.getDescribe();
        try {
            throw new BusinessException(message);
        } catch (BusinessException exception) {
            Assert.assertEquals(exception.getMessage(), message);
            Assert.assertEquals(exception.getResultCode(), ResultCodeEnum.BUSINESS_EXCEPTION.getCode());
        }
    }
}