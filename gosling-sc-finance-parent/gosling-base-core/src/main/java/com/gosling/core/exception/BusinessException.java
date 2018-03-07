package com.gosling.core.exception;

/**
 * 
 * @类描述：异常
 * @项目名称：gosling-base-core
 * @包名： com.gosling.core.exception
 * @类名称：BusinessException
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午3:01:41
 */
public class BusinessException extends RuntimeException {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}