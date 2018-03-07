package com.gosling.core.exception;

/**
 * 
 * @类描述：参数异常
 * @项目名称：gosling-base-core
 * @包名： com.gosling.core.exception
 * @类名称：ArgumentException
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午3:01:52
 */
public class ArgumentException extends BusinessException {

    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -5961619353798906031L;

    public ArgumentException(String message) {
        super(message);
    }

}
