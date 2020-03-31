package com.tank.protocol.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
@ToString(of = {"memberCode"})
public class BasicMember {

  private String memberCode;

}
