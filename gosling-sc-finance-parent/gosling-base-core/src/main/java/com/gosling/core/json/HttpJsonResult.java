package com.gosling.core.json;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @类描述：异步交互数据处理
 * @项目名称：gosling-base-core
 * @包名： com.gosling.core.json
 * @类名称：HttpJsonResult
 * @创建人：Administrator
 * @创建时间：2018年3月7日下午3:03:09
 */
public class HttpJsonResult<T> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -8637111820477625638L;

    public HttpJsonResult() {

    }

    public HttpJsonResult(T rows) {
        this.rows = rows;
    }

    /**
     * //一旦调用这里就是存在异常 前台对应的进入false判断里
     * @param errorMessage
     */
    public HttpJsonResult(String errorMessage) {
        this.success = false;
        this.message = errorMessage;
    }

    private Boolean success = true;//success默认为true

    public Boolean getSuccess() {
        return this.success;
    }

    private T rows;

    public T getRows() {
        return rows == null ? (T) new ArrayList() : rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private Integer total = 0;

    public void setTotal(Integer count) {
        this.total = count;
    }

    public Integer getTotal() {
        return this.total;
    }

    private String backUrl;

    public String getBackUrl() {
        return backUrl;
    }

    public void setBackUrl(String backUrl) {
        this.backUrl = backUrl;
    }

    private T footer;

    public T getFooter() {
        return footer == null ? (T) new ArrayList() : footer;
    }

    public void setFooter(T footer) {
        this.footer = footer;
    }
}
