package com.tank.controller;

import com.tank.protocol.ApiRes;
import com.tank.protocol.member.BasicMember;
import com.tank.protocol.member.VipMember;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sentinel")
public class MemberController {

  @PostMapping("/registerBasicMember")
  public ResponseEntity<ApiRes<String>> registerMember(@RequestBody @NonNull final BasicMember basicMember) {

    ApiRes<String> tips = ApiRes.<String>builder().build();
    tips.setBody(basicMember.toString());

    return ResponseEntity.ok(tips);
  }

  @PostMapping("/registerVipMember")
  public ResponseEntity<ApiRes<String>> registerVipMember(@RequestBody @NonNull final VipMember vipMember) {

    ApiRes<String> tips = ApiRes.<String>builder().build();
    tips.setBody(vipMember.toString());
    return ResponseEntity.ok(tips);
  }

}
