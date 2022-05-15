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
    return memberRepository.save(MemberMapper.INSTANCE.memberDtoToMember(memberDto));
  }

}
