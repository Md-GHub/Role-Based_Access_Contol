package com.mdghub.myapp.controller;


import com.mdghub.myapp.responce.LoginResponse;
import com.mdghub.myapp.responce.UserResponse;
import com.mdghub.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/logincontroller")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginResponse user) {
        UserResponse response = userService.loginUser(user);
        return ResponseEntity.ok(response);
    }
}
