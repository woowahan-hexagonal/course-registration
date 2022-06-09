package com.hexagonal.courseregistration.user.adapter.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.courseregistration.user.application.Registrant;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.hexagonal.courseregistration.user.application.Authority.STUDENT;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserApiTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @MockBean
  private Registrant registrant;

  @Test
  void signUp() throws Exception {
    var userApi = new UserApi(registrant);
    var mockMvc = MockMvcBuilders.standaloneSetup(userApi).build();
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
      .andExpect(jsonPath("message").value("Success SignUp"))
      .andExpect(jsonPath("data").value(IsNull.nullValue()));
  }
}