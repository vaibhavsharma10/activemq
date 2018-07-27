package com.vaibhav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.stereotype.Controller;

@Controller
@ComponentScan("com.vaibhav")
@SpringBootApplication(scanBasePackages = {"com.vaibhav"})
@EnableJms
public class Main {

 
  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

 
 
}
