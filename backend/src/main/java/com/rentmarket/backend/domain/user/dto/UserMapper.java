package com.rentmarket.backend.domain.user.dto;

import com.rentmarket.backend.common.annotation.Converter;
import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.db.user.User;

import lombok.RequiredArgsConstructor;


import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserMapper {

    public User toEntity(UserRegisterRequest request){

        return Optional.ofNullable(request)
                .map(it -> {
                    // to entity
                    return User.builder()
                            .username(request.getUsername())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .phoneNumber(request.getPhoneNumber())
                            .location(request.getLocation())
                            .build();

                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
    }

    public UserResponse toResponse(User user) {

        return Optional.ofNullable(user)
                .map(it ->{
                    // to response
                    return UserResponse.builder()
                            .id(user.getId())
                            .username(user.getUsername())
                            .email(user.getEmail())
                            .location(user.getLocation())
                            .phoneNumber(user.getPhoneNumber())
                            .build();
                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
    }
}
