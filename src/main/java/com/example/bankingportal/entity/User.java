package com.example.bankingportal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * User
 * 用户实体
 *
 * @author fuhao
 * @date 2022/5/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    /**
     * 唯一标识符
     */
    private String id;
    /**
     * IBAN id
     */
    private String accountId;
}
