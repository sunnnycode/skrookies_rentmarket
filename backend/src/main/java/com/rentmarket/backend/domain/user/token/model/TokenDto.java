package com.rentmarket.backend.domain.user.token.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TokenDto {
    private String token;

    private LocalDateTime expiredAt;
}
