package com.tank.protocol;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @param <T>
 * @author tank198435163.com
 */
@Getter
@Setter
@Accessors(chain = true)
@Builder
public class ApiRes<T> {

  private int code = -1;

  private String error = "-";

  private T body;

}
