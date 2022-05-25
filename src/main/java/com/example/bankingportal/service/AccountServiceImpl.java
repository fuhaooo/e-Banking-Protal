package com.example.bankingportal.service;

import com.example.bankingportal.request.TransactionRequest;
import com.example.bankingportal.response.TransactionResponse;
import org.apache.kafka.streams.KafkaStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * AccountServiceImpl
 * 账户服务实现类
 *
 * @author fuhao
 * @date 2022/5/24
 */
@Service
public class AccountServiceImpl implements AccountService{

    private final Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    private KafkaStreams kafkaStreams;

    @Value(value = "${kafka.streams.stateStoreName}")
    private String stateStoreName;

    @Override
    public List<TransactionResponse> pageListTransactions(TransactionRequest request) {
        log.info("AccountServiceImpl pageListTransactions");
        List<TransactionResponse> list =  new ArrayList<TransactionResponse>();
        return list;
    }


}
