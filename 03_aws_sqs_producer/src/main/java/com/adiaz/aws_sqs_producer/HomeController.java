package com.adiaz.aws_sqs_producer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

@RestController
@AllArgsConstructor
@Slf4j
public class HomeController {

  private final SqsTemplate sqsTemplate;

  @GetMapping("send_message")
  public ResponseEntity<String> home() {
    String dateStr = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
    CompletableFuture<SendResult<String>> sendResultCompletableFuture = sqsTemplate.sendAsync("sending message at ->" + dateStr);
    sendResultCompletableFuture.whenCompleteAsync((t, u) -> {
      log.info("message ID {}", t.messageId());
    });
    return ResponseEntity.ok("home... " + dateStr);
  }

}
