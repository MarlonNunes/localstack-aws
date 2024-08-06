package com.marlonnunes.localstack.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marlonnunes.localstack.MessageDTO;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @Value("${aws.queue-name}")
    private String queueName;

    @SqsListener("${aws.queue-name}")
    public void consume(MessageDTO message) {
        log.info("Message consumed: {}", message);
    }
}
