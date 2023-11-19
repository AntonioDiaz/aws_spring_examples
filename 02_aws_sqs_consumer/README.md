# Listening AWS SQS

![image](https://github.com/AntonioDiaz/aws_spring_examples/assets/725743/36e8406c-c812-478f-ba88-2f7eda65e7e3)

* Add `pom` dependency management for AWS Spring:   
https://docs.awspring.io/spring-cloud-aws/docs/3.0.3/reference/html/index.html
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>io.awspring.cloud</groupId>
            <artifactId>spring-cloud-aws-dependencies</artifactId>
            <version>3.0.3</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

* Add `pom` dependency
```xml
<dependency>
    <groupId>io.awspring.cloud</groupId>
    <artifactId>spring-cloud-aws-starter-sqs</artifactId>
</dependency>
```

* Adding listener with annotation `@SqsListener`, this will create the queue if does not exits. 
```java
@Component
@Slf4j
public class QueueListener {
  
  @SqsListener(value = "aws_spring_testing_queue")
  public void listen(String message) {
    log.info("testing queue message received {}", message);
    HomeController.messages.add(message);
  }
  
}
```
