package com.example.bankingportal.model;

import lombok.Data;

/**
 * LoginUser
 * 登录用户
 *
 * @author fuhao
 * @date 2022/5/24
 */
@Data
public class LoginUser {

    private String username;
    private String password;
    private Integer rememberMe;
}
