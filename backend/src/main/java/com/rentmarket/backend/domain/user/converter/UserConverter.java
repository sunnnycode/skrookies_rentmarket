package com.rentmarket.backend.domain.user.converter;

import com.rentmarket.backend.common.annotation.Converter;
import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.db.user.UserEntity;
import com.rentmarket.backend.domain.user.controller.model.UserRegisterRequest;
import com.rentmarket.backend.domain.user.controller.model.UserResponse;
import lombok.RequiredArgsConstructor;


import java.util.Optional;

@RequiredArgsConstructor
@Converter
public class UserConverter {

    public UserEntity toEntity(UserRegisterRequest request){

        return Optional.ofNullable(request)
                .map(it -> {
                    // to entity
                    return UserEntity.builder()
                            .username(request.getUsername())
                            .email(request.getEmail())
                            .password(request.getPassword())
                            .phoneNumber(request.getPhoneNumber())
                            .location(request.getLocation())
                            .build();

                })
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserRegisterRequest Null"));
    }

    public UserResponse toResponse(UserEntity userEntity) {

        return Optional.ofNullable(userEntity)
            .map(it ->{
                // to response
                return UserResponse.builder()
                        .id(userEntity.getId())
                        .username(userEntity.getUsername())
                        .email(userEntity.getEmail())
                        .location(userEntity.getLocation())
                        .phoneNumber(userEntity.getPhoneNumber())
                        .createdAt(userEntity.getCreatedAt())
                        .build();
            })
                    .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "UserEntity Null"));
        }
    }

