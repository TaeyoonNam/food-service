package me.naming.foodservice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;

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
  @NotBlank(message = "이메일은 필수 입력 값입니다.")
  @Email(message = "이메일 형식에 맞지 않습니다.")
  private String email;

  @NotBlank(message = "이름은 필수 입력 값입니다.")
  private String name;

  @NotBlank(message = "비밀번호를 입력해주시기 바랍니다.")
  @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}",
      message = "비밀번호는 영문 대,소문자와 숫자, 특수기호가 적어도 1개 이상씩 포함된 8자 ~ 20자의 비밀번호여야 합니다.")
  private String password;

  @Builder
  public MemberDto(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }

  public void encryptPassword() {
    this.password = DigestUtils.sha256Hex(password);
  }
}
