package com.camunda.example;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.spring.boot.starter.property.CamundaBpmProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }


  @EventListener
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    CamundaBpmProperties camProps= contextRefreshedEvent.getApplicationContext().getBean(CamundaBpmProperties.class);
    log.info("--- CamundaProperties: {}", camProps);
  }
}