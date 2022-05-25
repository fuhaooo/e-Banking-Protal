package com.example.bankingportal.config;

import com.example.bankingportal.request.TransactionRequest;
import com.example.bankingportal.response.TransactionResponse;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.StateStore;
import org.apache.kafka.streams.state.KeyValueStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * TranactionsStreamsProcessor
 *
 * @author fuhao
 * @date 2022/5/24
 */
public class TranactionsStreamsProcessor implements Processor<Long, TransactionResponse> {

    private final Logger log = LoggerFactory.getLogger(TranactionsStreamsProcessor.class);

    private StateStore stateStore;

    @Value(value = "${kafka.streams.stateStoreName}")
    private String stateStoreName;

    @Override
    public void init(ProcessorContext context) {
        stateStore =  context.getStateStore(stateStoreName);
        Objects.requireNonNull(stateStore, "State store can't be null");
    }

    @Override
    public void process(Long txId, TransactionResponse transactions) {
        log.info("Streams Request to save process transactions : {}", transactions);
    }

    @Override
    public void punctuate(long timestamp) {

    }

    @Override
    public void close() {

    }
}
