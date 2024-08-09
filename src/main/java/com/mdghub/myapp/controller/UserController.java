package com.mdghub.myapp.controller;

import com.mdghub.myapp.entity.User;
import com.mdghub.myapp.responce.LoginResponse;
import com.mdghub.myapp.responce.UserResponse;
import com.mdghub.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usercontrol")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user) {
        UserResponse response = userService.addUser(user);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/user/edit")
    public ResponseEntity<UserResponse> editUser(@RequestBody User user) {
        try {
            System.out.println("hi");
            UserResponse updatedUserResponse = userService.editUser(user);
            return ResponseEntity.ok(updatedUserResponse);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new UserResponse());
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
