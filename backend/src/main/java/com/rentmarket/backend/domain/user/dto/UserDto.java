package com.rentmarket.backend.domain.user.dto;

import com.rentmarket.backend.db.user.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class UserDto {

    private int id;

    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    private String location;

    private LocalDateTime createdAt;

    private UserStatus status;



}
