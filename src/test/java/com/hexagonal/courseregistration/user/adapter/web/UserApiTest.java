package com.hexagonal.courseregistration.user.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.courseregistration.user.application.ExistUserException;
import com.hexagonal.courseregistration.user.application.Registrant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
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
  private Registrant registrant;

  @Test
  void signUp() throws Exception {
    var jsonRequest = new JsonRegisterRequest(
      "seungjaeOh",
      "17101223",
      STUDENT
    );
    var actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/user").content(
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
    doThrow(new ExistUserException()).when(registrant).register(any());

    var actual = mockMvc.perform(MockMvcRequestBuilders.post("/api/user").content(
        mapper.writeValueAsString(jsonRequest))
      .contentType(MediaType.APPLICATION_JSON));

    actual
      .andExpect(status().isBadRequest())
      .andExpect(jsonPath("message").value("Already Exist User"));
  }
}