package com.adiaz.aws_sqs_consumer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeController {

  public static List<String> messages = new ArrayList<>();

  @GetMapping("/show-messages")
  public ResponseEntity<String> showMessages() {
    String messagesStr = messages.isEmpty() ? "no messages" : String.join("\n", messages);
    return ResponseEntity.ok("messages (since start application) -> " + messagesStr);
  }
}
