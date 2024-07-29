package com.rentmarket.backend.domain.user.service;

import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.error.UserErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.db.user.UserEntity;
import com.rentmarket.backend.db.user.UserRepository;
import com.rentmarket.backend.db.user.enums.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * User 도메인 로직을 처리 하는 서비스
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;


    public UserEntity register(UserEntity userEntity){
        return Optional.ofNullable(userEntity)
                .map(it ->{
                    userEntity.setStatus(UserStatus.REGISTERED);
                    userEntity.setCreatedAt(LocalDateTime.now());
                    return userRepository.save(userEntity);
                })
                .orElseThrow(() -> new ApiException(ErrorCode.NULL_POINT, "User Entity Null"));
    }

    public UserEntity login(
            String email,
            String password
    ){
        var entity = getUserWithThrow(email, password);
        return entity;
    }

    public UserEntity getUserWithThrow(
            String email,
            String password
    ){
        return userRepository.findFirstByEmailAndPasswordAndStatusOrderByIdDesc(
                email,
                password,
                UserStatus.REGISTERED
        ).orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }

    public UserEntity getUserWithThrow(
            int id
    ){
        return userRepository.findFirstByIdAndStatusOrderByIdDesc(
                id,
                UserStatus.REGISTERED
        ).orElseThrow(()-> new ApiException(UserErrorCode.USER_NOT_FOUND));
    }
}