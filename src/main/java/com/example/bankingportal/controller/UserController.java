package com.example.bankingportal.controller;

import com.example.bankingportal.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController
 * 用户服务接口
 *
 * @author fuhao
 * @date 2022/5/21
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户服务相关接口")
public class UserController {

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有用户接口",notes = "<span style='color:red;'>接口描述:</span>&nbsp;&nbsp;用来查询所有用户信息")
    public String findAll(){
        String string = "查询所有transaction";
        return string;
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存用户接口",notes = "<span style='color:red;'>接口描述:</span>&nbsp;&nbsp;保存用户信息")
    @ApiResponses({
            @ApiResponse(code = 401, message = "当前请求未被授权"),
            @ApiResponse(code = 404, message = "当前请求路径不存在")
    })
    public List<User> save(@RequestBody User user){
        return null;
    }
}
