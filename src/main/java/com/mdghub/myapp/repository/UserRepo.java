package com.mdghub.myapp.repository;

import com.mdghub.myapp.entity.User;
import com.mdghub.myapp.responce.LoginResponse;
import com.mdghub.myapp.responce.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT * from user where user_name = :username and password = :password",
            nativeQuery = true
    )
    public User loginUserCheck(@Param("username") String username,@Param("password") String password);

    @Query(
            value = "select role_name from user_role where role_id = (select role_id from user where user_id = :id)",
            nativeQuery = true
    )
    public String roleCheck(@Param("id") Long id);
}
