# Reading AWS Parameter Store values

* Create parameter on AWS console

![image](https://github.com/AntonioDiaz/aws_spring_examples/assets/725743/766f6777-5583-4531-abb4-b9909518d06f)

* Add `pom` dependency management for AWS Spring: https://docs.awspring.io/spring-cloud-aws/docs/3.0.3/reference/html/index.html
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
    <artifactId>spring-cloud-aws-starter-parameter-store</artifactId>
</dependency>
```

* Add prefix property
```properties
spring.config.import=optional:aws-parameterstore:/my-app/dev
```

* Reading value
```java
public HomeController(@Value("${custom.bucket-name}") String bucketName) {
  this.bucketName = bucketName;
}
```
