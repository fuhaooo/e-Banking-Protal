package com.example.bankingportal.controller;

import com.example.bankingportal.request.TransactionRequest;
import com.example.bankingportal.response.BaseResponse;
import com.example.bankingportal.response.ErrorMessage;
import com.example.bankingportal.response.TransactionResponse;
import com.example.bankingportal.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * AccountController
 * 账户服务接口
 *
 * @author fuhao
 * @date 2022/5/23
 */
@RestController
@RequestMapping("/account")
@Api(tags = "账户服务相关接口")
public class AccountController {

    private final Logger log = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AccountService accountService;

    @PostMapping("/transactions")
    @PreAuthorize("hasRole('ADMIN')")
    @ApiOperation(value = "获取transactions接口",notes = "<span style='color:red;'>接口描述:</span>&nbsp;&nbsp;用户用来获取分页transactions的的接口")
    @ApiResponses({
            @ApiResponse(code = 401, message = "当前请求未被授权"),
            @ApiResponse(code = 404, message = "当前请求路径不存在")
    })
    public BaseResponse getTransactionsMesseage(@RequestBody TransactionRequest request){
        log.info("正在获取transactions");
        try {
            List<TransactionResponse> responseList = accountService.pageListTransactions(request);
            return new BaseResponse(true,"get the responseList success",responseList);
        }catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorMsg(e.getMessage());
            return new BaseResponse(false, errorMessage.getErrorMsg(),null);
        }
    }
}
