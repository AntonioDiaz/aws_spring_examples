package com.adiaz.aws_sqs_consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class QueueListener {
  @SqsListener(value = "aws_spring_testing_queue")
  public void listen(String message) {
    log.info("testing queue message received {}", message);
    HomeController.messages.add(message);
  }
}
