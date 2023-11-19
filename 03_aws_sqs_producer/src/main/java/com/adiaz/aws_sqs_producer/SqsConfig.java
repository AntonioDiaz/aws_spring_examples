package com.adiaz.aws_sqs_producer;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import io.awspring.cloud.sqs.operations.TemplateAcknowledgementMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class SqsConfig {

  @Bean
  public SqsAsyncClient sqsAsyncClient() {
    return SqsAsyncClient.builder().build();
  }

  @Bean
  public SqsTemplate sqsTemplate() {
    return SqsTemplate.builder()
            .sqsAsyncClient(sqsAsyncClient())
            .configure(options -> options
                    .acknowledgementMode(TemplateAcknowledgementMode.MANUAL)
                    .defaultQueue("aws_spring_testing_queue"))
            .build();
  }

}
