package com.tank.protocol.order;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderPayedReq {

  private BigDecimal price;

  private PayWay payWay;

}
