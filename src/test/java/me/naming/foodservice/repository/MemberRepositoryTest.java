package me.naming.foodservice.repository;

import static org.assertj.core.api.Assertions.assertThat;

import me.naming.foodservice.domain.Member;
import me.naming.foodservice.dto.MemJoinStatus;
import me.naming.foodservice.dto.MemberDto;
import me.naming.foodservice.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;

  @Test
  public void add () {
    Member insertMember = new Member(MemJoinStatus.NORMAL, "testing", "test@gmail.com", "testPwd", "01012341234");
    memberRepository.save(insertMember);
    Member selectedMember = memberRepository.getMemberByEmail(insertMember.getEmail());

    assertThat(selectedMember.getEmail()).isEqualTo(insertMember.getEmail());
    assertThat(selectedMember.getMemJoinStatus()).isEqualTo(insertMember.getMemJoinStatus());
    assertThat(selectedMember.getName()).isEqualTo(insertMember.getName());
    assertThat(selectedMember.getMobileNum()).isEqualTo(insertMember.getMobileNum());
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