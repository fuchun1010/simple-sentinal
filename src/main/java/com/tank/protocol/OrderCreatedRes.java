package com.tank.protocol;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCreatedRes {

  private String id;

  @Override
  public String toString() {

    return MoreObjects.toStringHelper(this).
        add("orderId = ", this.id)
        .toString();
  }
}
