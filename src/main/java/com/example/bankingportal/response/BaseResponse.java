package com.example.bankingportal.response;

/**
 * BaseResponse
 * API接口基础返回类
 *
 * @author fuhao
 * @date 2022/5/23
 */
public class BaseResponse<T> {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }
}
