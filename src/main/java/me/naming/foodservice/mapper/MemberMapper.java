package me.naming.foodservice.mapper;

import me.naming.foodservice.domain.Member;
import me.naming.foodservice.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author : naming
 * @packageName : me.naming.foodservice.mapper
 * @date : 2022/05/14
 * @description :
 */
@Mapper
public interface MemberMapper {

  MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

  Member memberDtoToMember(MemberDto memberDto);

  MemberDto memberToMemberDto(Member memberDto);

}
