package com.rentmarket.backend.domain.user.token.business;

import com.rentmarket.backend.common.annotation.Business;
import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.db.user.User;
import com.rentmarket.backend.domain.user.token.controller.model.TokenResponse;
import com.rentmarket.backend.domain.user.token.converter.TokenConverter;
import com.rentmarket.backend.domain.user.token.service.TokenService;
import lombok.RequiredArgsConstructor;


import java.util.Optional;

@RequiredArgsConstructor
@Business
public class TokenBusiness {

    private final TokenService tokenService;

    private final TokenConverter tokenConverter;

    /**
     * 1. user entity user Id 추출
     * 2. access, refresh token 발행
     * 3. converter -> token response로 변경
     */

    public TokenResponse issueToken(User userEntity){

        return Optional.ofNullable(userEntity)
                .map(user -> {
                    return user.getId();
                })
                .map(userId -> {
                    var accessToken = tokenService.issueAccessToken(userId);
                    var refreshToken = tokenService.issueRefreshToken(userId);
                    return tokenConverter.toResponse(accessToken, refreshToken);
                })
                .orElseThrow(
                        ()-> new ApiException(ErrorCode.NULL_POINT)
                );


    }

    public Long validationAccessToken(String accessToken){
        var userId = tokenService.validationToken(accessToken);
        return userId;
    }
}