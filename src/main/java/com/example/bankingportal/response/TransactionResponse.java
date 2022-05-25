package com.example.bankingportal.response;

import lombok.Data;

/**
 * TransactionResponse
 * 交易response
 *
 * @author fuhao
 * @date 2022/5/24
 */
@Data
public class TransactionResponse {

    /**
     * 唯一标识符
     */
    private String transaction_uuid;

    /**
     * 国际金融账户ID
     */
    private String ibanId;

    /**
     * 金额
     */
    private Float amount;

    /**
     * 描述
     */
    private String description;

    /**
     * valueDate
     */
    private String valueDate;


}
