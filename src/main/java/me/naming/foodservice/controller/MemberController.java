package me.naming.foodservice.controller;

import javax.validation.Valid;
import me.naming.foodservice.dto.MemberDto;
import me.naming.foodservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

  @Autowired
  private MemberService memberService;

  @PostMapping("/member")
  public ResponseEntity registerMember(@RequestBody @Valid MemberDto memberDto) {
    return ResponseEntity.ok(memberService.save(memberDto));
  }

}