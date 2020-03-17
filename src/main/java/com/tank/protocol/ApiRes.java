package com.tank.protocol;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ApiRes<T> {

  private int code = -1;

  private String error = "-";

  private T body;

}
