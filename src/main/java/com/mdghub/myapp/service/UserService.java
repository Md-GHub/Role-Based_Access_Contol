package com.mdghub.myapp.service;

import com.mdghub.myapp.entity.User;
import com.mdghub.myapp.entity.UserRole;
import com.mdghub.myapp.repository.UserRepo;
import com.mdghub.myapp.repository.UserRoleRepo;
import com.mdghub.myapp.responce.LoginResponse;
import com.mdghub.myapp.responce.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    public UserResponse addUser(User user) {
        Optional<UserRole> defaultRoleOptional = userRoleRepo.findById(2L);
        if (user.getUserRole() == null || user.getUserRole().getRoleId() != 1) {
            if (defaultRoleOptional.isPresent()) {
                UserRole defaultRole = defaultRoleOptional.get();
                user.setUserRole(defaultRole);
            } else {
                throw new RuntimeException("Default role with ID 2 not found");
            }
        }
        return setUserResponse(userRepo.save(user));
    }
    public UserResponse getUserById(Long id) {
        // Fetch user data without any role checks
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return setUserResponse(user);
    }

    public UserResponse loginUser(LoginResponse loginResponse) {
        if (loginResponse == null || loginResponse.getUserName() == null || loginResponse.getPassword() == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }

        User user = userRepo.loginUserCheck(loginResponse.getUserName(), loginResponse.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid login request");
        }
        return setUserResponse(user);
    }

    public UserResponse editUser(User user) {
        System.out.println(user.getUserId());
        if (user == null || user.getUserId() == null) {
            throw new IllegalArgumentException("Invalid user data");
        }

        System.out.println("2");
        User existingUser = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update fields only if the new values are not null
        if (user.getUserName() != null) {
            existingUser.setUserName(user.getUserName());
        }
        if (user.getPassword() != null) {
            existingUser.setPassword(user.getPassword());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getPhone() != null) {
            System.out.println(user.getPhone());
            existingUser.setPhone(user.getPhone());
        }
        if (user.getFirstName() != null) {
            existingUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            existingUser.setLastName(user.getLastName());
        }

        // Save the updated user back to the database
        User updatedUser = userRepo.save(existingUser);

        // Return the updated user response
        return setUserResponse(updatedUser);
    }

    public String deleteUserById(Long id) {
        if(!userRepo.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepo.deleteById(id);
        return ;
    }

    private UserResponse setUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhone(user.getPhone());
        userResponse.setUserName(user.getUserName());
        userResponse.setId(user.getUserId());
        return userResponse;
    }


}
