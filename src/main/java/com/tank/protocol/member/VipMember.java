package com.tank.protocol.member;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tank198435163.com
 */
@Getter
@Setter
public class VipMember extends BasicMember {

  private int money;


  @Override
  public String toString() {

    return MoreObjects.
        toStringHelper(this)
        .add("memberCode", this.getMemberCode())
        .add("money", this.getMoney())
        .toString();
  }
}
