package me.naming.foodservice.service;

import me.naming.foodservice.domain.Member;
import me.naming.foodservice.dto.MemberDto;
import me.naming.foodservice.mapper.MemberMapper;
import me.naming.foodservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  private MemberRepository memberRepository;

  public Member save(MemberDto memberDto) {
    memberDto.encryptPassword();
    Member member = MemberMapper.INSTANCE.memberDtoToMember(memberDto);
    return memberRepository.save(member);
  }

  public Member login(MemberDto memberDto) {
    Member member = memberRepository.getMemberByEmail(memberDto.getEmail());
    memberDto.encryptPassword();

    if(!member.getPassword().equals(memberDto.getPassword())) {
      throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
    }

    return member;
  }

}
