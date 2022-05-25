package com.example.bankingportal.request;

import lombok.Data;

/**
 * TransactionRequest
 * 交易入参类
 *
 * @author fuhao
 * @date 2022/5/24
 */
@Data
public class TransactionRequest {

    /**
     * 账户ID
     */
    private String accountId;

    /**
     * 月份
     */
    private int month;

    /**
     * 时间
     */
    private int year;
}
