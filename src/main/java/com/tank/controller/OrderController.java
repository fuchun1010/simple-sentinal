package com.tank.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tank.protocol.ApiRes;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tank198435163.com
 */
@Slf4j
@RestController
@RequestMapping("/sentinel")
public class OrderController {

  @GetMapping("/hello")
  @SentinelResource(value = "hello")
  public ResponseEntity<ApiRes<String>> sayHello() {
    val result = new ApiRes<String>();
    result.setBody("hello").setCode(200);
    ResponseEntity<ApiRes<String>> response = ResponseEntity.ok(result);
    return response;
  }
}
