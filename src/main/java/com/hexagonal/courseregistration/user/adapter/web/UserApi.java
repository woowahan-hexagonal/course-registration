package com.hexagonal.courseregistration.user.adapter.web;

import com.hexagonal.courseregistration.common.adapter.web.ResponseFactory;
import com.hexagonal.courseregistration.user.application.Registrant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApi {
  private final Registrant registrant;

  @PostMapping
  public ResponseEntity<?> signUp(@RequestBody JsonRegisterRequest jsonRequest) {
    registrant.register(jsonRequest.toRegisterRequest());

    return ResponseFactory.ok("Success SignUp");
  }
}
