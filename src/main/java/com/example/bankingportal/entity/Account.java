package com.example.bankingportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * Account
 * 账户实体
 *
 * @author fuhao
 * @date 2022/5/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Account {

    /**
     * 账户唯一标识符（UUID）
     */
    private String uuid;

    /**
     * 银行账户ID
     */
    private String accountId;

    /**
     * 电话号码
     */
    private Long msisdn;

    /**
     * 贷方余额
     */
    private BigDecimal creditBalance;

    /**
     * 借方余额
     */
    private BigDecimal debitBalance;

    /**
     * 货币种类
     */
    private String currency;

}
