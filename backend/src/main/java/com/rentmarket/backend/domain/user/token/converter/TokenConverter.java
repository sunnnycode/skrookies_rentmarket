package com.rentmarket.backend.domain.user.token.converter;

import com.rentmarket.backend.common.annotation.Converter;
import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.domain.user.token.controller.model.TokenResponse;
import com.rentmarket.backend.domain.user.token.model.TokenDto;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Converter
public class TokenConverter {

    public TokenResponse toResponse(
            TokenDto accessToken,
            TokenDto refreshToken
    ){
        Objects.requireNonNull(accessToken, ()->{throw new ApiException(ErrorCode.NULL_POINT);});
        Objects.requireNonNull(refreshToken, ()->{throw new ApiException(ErrorCode.NULL_POINT);});

        return TokenResponse.builder()
                .accessToken(accessToken.getToken())
                .accessTokenExpiredAt(accessToken.getExpiredAt())
                .refreshToken(refreshToken.getToken())
                .refreshTokenExpiredAt(refreshToken.getExpiredAt())
                .build();
    }
}
