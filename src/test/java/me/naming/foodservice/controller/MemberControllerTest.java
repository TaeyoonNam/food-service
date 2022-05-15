package me.naming.foodservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import me.naming.foodservice.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * @author : naming
 * @packageName : me.naming.foodservice.controller
 * @date : 2022/05/15
 * @description :
 */
@WebMvcTest(MemberController.class)
class MemberControllerTest {

  @MockBean
  private MemberService memberService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void Validation_Exception_Password() throws Exception {

    MvcResult result = mockMvc.perform(post("/member")
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content("{\n"
            + "    \"name\": \"JUnitTest\",\n"
            + "    \"email\": \"JUnit@test.com\",\n"
            + "    \"password\": \"123\"\n"
            + "}"))
        .andReturn();

    assertThat(result.getResolvedException().getMessage()).contains("비밀번호는");
  }

  @Test
  void Validation_Exception_Email() throws Exception {

    MvcResult result = mockMvc.perform(post("/member")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .content("{\n"
                + "    \"name\": \"JUnitTest\",\n"
                + "    \"email\": \"JUnit\",\n"
                + "    \"password\": \"123\"\n"
                + "}"))
        .andReturn();

    assertThat(result.getResolvedException().getMessage()).contains("이메일 형식에 맞지 않습니다.");
  }
}