package com.example.bankingportal.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * BaseResponse
 * API接口基础返回类
 *
 * @author fuhao
 * @date 2022/5/23
 */
@Data
public class BaseResponse {

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
    private List<?> data;

    public BaseResponse(boolean success, String msg, List<TransactionResponse> responseList) {
        this.success = success;
        this.msg = msg;
        this.data = responseList;
    }
}