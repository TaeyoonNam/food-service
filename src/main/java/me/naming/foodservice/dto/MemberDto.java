package me.naming.foodservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : naming
 * @packageName : me.naming.foodservice.dto
 * @date : 2022/05/14
 * @description :
 */
@Getter
@NoArgsConstructor
@ToString
public class MemberDto {

  private String email;

  private String name;

  private String password;

  @Builder
  public MemberDto(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }
}
