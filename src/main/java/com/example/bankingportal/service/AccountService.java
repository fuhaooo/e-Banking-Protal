package com.example.bankingportal.service;

import com.example.bankingportal.request.TransactionRequest;
import com.example.bankingportal.response.TransactionResponse;

import java.util.List;

/**
 * AccountService
 * 账户相关Service
 *
 * @author fuhao
 * @date 2022/5/24
 */
public interface AccountService {

    public List<TransactionResponse> pageListTransactions(TransactionRequest request);
}
