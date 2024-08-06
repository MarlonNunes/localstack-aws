package com.marlonnunes.localstack.publisher;

import com.marlonnunes.localstack.MessageDTO;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Publisher {
    @Value("${aws.queue-name}")
    private String queueName;

    private final SqsTemplate template;
    public void publish(MessageDTO message) {
            template.send(queueName, message);
    }
}
