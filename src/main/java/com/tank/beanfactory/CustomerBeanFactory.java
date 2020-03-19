package com.tank.beanfactory;

import com.tank.util.KeySeq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerBeanFactory {

  @Bean
  public CommandLineRunner init(@Autowired KeySeq keySeq) {
    return args -> {
      System.out.println("I am initialization");
      keySeq.initOnce();
      keySeq.startMonitorOnce();
    };
  }

  @Bean
  public KeySeq initKeySeqBean() {
    return new KeySeq();
  }


}
