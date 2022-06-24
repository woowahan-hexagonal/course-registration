package com.hexagonal.courseregistration.user.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.courseregistration.user.application.RegisterUserUseCase;
import com.hexagonal.courseregistration.user.application.UserException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static com.hexagonal.courseregistration.user.application.ErrorMessage.ALREADY_EXIST_USER;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserApiTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @MockBean
  private RegisterUserUseCase registerUserUsecase;

  @Test
  void signUp() throws Exception {
    var jsonRequest = new JsonRegisterRequest(
      "seungjaeOh",
      "17101223",
      STUDENT
    );
    var actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/users").content(
        mapper.writeValueAsString(jsonRequest))
      .contentType(MediaType.APPLICATION_JSON));

    actual
      .andExpect(status().isOk())
      .andExpect(jsonPath("message").value("Success SignUp"));
  }

  @Test
  void signUp_exist_user() throws Exception {
    var jsonRequest = new JsonRegisterRequest(
      "seungjaeOh",
      "17101223",
      STUDENT
    );
    doThrow(new UserException(ALREADY_EXIST_USER)).when(registerUserUsecase).register(any());

    var actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/users").content(
        mapper.writeValueAsString(jsonRequest))
      .contentType(MediaType.APPLICATION_JSON));

    actual
      .andExpect(status().isBadRequest())
      .andExpect(jsonPath("message").value("Already Exist User"));
  }
}