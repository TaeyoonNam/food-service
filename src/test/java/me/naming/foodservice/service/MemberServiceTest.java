package me.naming.foodservice.service;

import static org.assertj.core.api.Assertions.assertThat;

import me.naming.foodservice.domain.Member;
import me.naming.foodservice.dto.MemJoinStatus;
import me.naming.foodservice.dto.MemberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : naming
 * @packageName : me.naming.foodservice.service
 * @date : 2022/05/19
 * @description :
 */
@SpringBootTest
class MemberServiceTest {

  @Autowired
  private MemberService memberService;

  @Test
  void save() {
    MemberDto memberDto = MemberDto.builder()
        .name("JUnitTest")
        .email("JUnit@test.com")
        .password("testPwd")
        .mobileNum("01012341234")
        .build();

    Member member = memberService.save(memberDto);
    assertThat(member.getMemJoinStatus()).isEqualTo(MemJoinStatus.NORMAL);
    assertThat(member.getEmail()).isEqualTo(memberDto.getEmail());
    assertThat(member.getName()).isEqualTo(memberDto.getName());
    assertThat(member.getMobileNum()).isEqualTo(memberDto.getMobileNum());
  }

  @Test
  void login() {
  }

}