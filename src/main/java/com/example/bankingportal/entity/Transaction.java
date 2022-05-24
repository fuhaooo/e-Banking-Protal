package com.example.bankingportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Transaction
 * 交易实体
 *
 * @author fuhao
 * @date 2022/5/23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Transaction {

    /**
     * 唯一标识符UUID
     */
    private String transactionId;

    /**
     * IBAN国际金融账户ID
     */
    private String ibanId;

    /**
     * 货币金额
     */
    private BigDecimal amount;

    /**
     * 描述（支付方式+货币种类）
     */
    private String description;


}
