package com.rentmarket.backend.domain.user.controller.model;


import com.rentmarket.backend.db.user.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    private int id;

    private String username;

    private String email;

    private String password;

    private int phoneNumber;

    private String location;

    private LocalDateTime createdAt;

    private UserStatus status;

}
