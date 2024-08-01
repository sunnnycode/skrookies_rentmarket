package com.rentmarket.backend.domain.user.dto;


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

    private String phoneNumber;

    private String location;

    private UserStatus status;

}
