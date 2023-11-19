package com.adiaz.aws_parameter_store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  private final String bucketName;

  public HomeController(@Value("${custom.bucket-name}") String bucketName) {
    this.bucketName = bucketName;
  }

  @GetMapping("/my-parameter")
  public ResponseEntity<String> showParameterValue() {
    return ResponseEntity.ok("parameter value ->" + bucketName);
  }
}
