package com.mdghub.myapp.controller;


import com.mdghub.myapp.entity.User;
import com.mdghub.myapp.responce.UserResponse;
import com.mdghub.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admincontrol")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse response = userService.getUserById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/createuser")
    public ResponseEntity<UserResponse> addUser(@RequestBody User user){
        return ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.deleteUserById(id));
    }


}
