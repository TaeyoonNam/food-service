package me.naming.foodservice;

import static org.assertj.core.api.Assertions.assertThat;

import me.naming.foodservice.domain.Member;
import me.naming.foodservice.dto.MemJoinStatus;
import me.naming.foodservice.dto.MemberDto;
import me.naming.foodservice.mapper.MemberMapper;
import me.naming.foodservice.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void add () {
    memberRepository.save(new Member(MemJoinStatus.NORMAL, "naming", "naming@gmail.com", "01022021812", "testPwd"));
  }

  @Test
  public void mapStructTest() {
    MemberDto memberDto = MemberDto.builder()
        .name("JUnitTest")
        .email("JUnit@test.com")
        .password("testPwd")
        .build();

    Member member = MemberMapper.INSTANCE.memberDtoToMember(memberDto);
    MemberDto chgMemberDto = MemberMapper.INSTANCE.memberToMemberDto(member);

    assertThat(member.getEmail()).isEqualTo(chgMemberDto.getEmail());
    assertThat(member.getName()).isEqualTo(chgMemberDto.getName());
    assertThat(member.getPassword()).isEqualTo(chgMemberDto.getPassword());
  }
}