package com.example.bankingportal.controller;

import com.example.bankingportal.entity.User;
import com.example.bankingportal.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * AuthController
 * 授权Controller
 *
 * @author fuhao
 * @date 2022/5/22
 */
@RestController
@RequestMapping("/auth")
@Api(tags = "注册相关接口")
public class AuthController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册接口",notes = "<span style='color:red;'>接口描述:</span>&nbsp;&nbsp;用户用来注册的接口")
    @ApiResponses({
            @ApiResponse(code = 401, message = "当前请求未被授权"),
            @ApiResponse(code = 404, message = "当前请求路径不存在")
    })
    public String registerUser(@RequestBody Map<String,String> registerUser){
        log.info("用户注册中");
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        User save = userRepository.save(user);
        return save.toString();
    }
}
