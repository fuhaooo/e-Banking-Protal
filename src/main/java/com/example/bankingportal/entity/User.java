package com.example.bankingportal.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * User
 * 用户实体
 *
 * @author fuhao
 * @date 2022/5/21
 */
@Entity
@Table(name = "e_banking_user")
@Data
public class User {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 角色
     */
    @Column(name = "role")
    private String role;
}
