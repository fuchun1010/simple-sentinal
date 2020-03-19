package com.tank.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tank.protocol.ApiRes;
import com.tank.protocol.order.OrderPayedReq;
import com.tank.protocol.order.OrderPayedRes;
import com.tank.protocol.order.PayResult;
import com.tank.util.KeySeq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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

    ResponseEntity<ApiRes<String>> response = ResponseEntity.ok(ApiRes.<String>builder().build().setBody("hello").setCode(200));
    return response;
  }

  /**
   * curl -XPOST "http://localhost:9099/sentinel/payment/s0001" -H "Content-Type:application/json" -d '{
   * "payWay":0,
   * "price": 11.6
   * }'
   *
   * @param order
   * @param orderPayedReq
   * @return
   */
  @PostMapping("/payment/{order}")
  public ResponseEntity<ApiRes<OrderPayedRes>> paymentForOrder(@PathVariable @NotNull final String order, @NotNull @RequestBody final OrderPayedReq orderPayedReq) {
    ResponseEntity<ApiRes<OrderPayedRes>> response = ResponseEntity
        .ok(ApiRes.<OrderPayedRes>builder().build().setCode(PayResult.Success.ordinal()));
    return response;
  }


  @GetMapping("/key")
  public ResponseEntity<ApiRes<String>> key() {
    String key = keySeq.take();
    ApiRes<String> result = ApiRes.<String>builder().build().setBody(key).setCode(200);
    return ResponseEntity.ok(result);
  }


  @Autowired
  private KeySeq keySeq;


}
