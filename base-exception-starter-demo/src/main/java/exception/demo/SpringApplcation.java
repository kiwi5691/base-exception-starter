package exception.demo;

import exception.annotation.EnableExceptionCatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableExceptionCatcher
@SpringBootApplication
public class SpringApplcation {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplcation.class, args);
    }
}
