package com.rentmarket.backend.domain.user.token.service;

import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.domain.user.token.Ifs.TokenHelperIfs;
import com.rentmarket.backend.domain.user.token.model.TokenDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

/**
 * token 에 대한 도메인로직
 */
@RequiredArgsConstructor
@Service
public class TokenService {

    private final TokenHelperIfs tokenHelperIfs;

    public TokenDto issueAccessToken(int userId){
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperIfs.issueAccessToken(data);

    }

    public TokenDto issueRefreshToken(int userId){
        var data = new HashMap<String, Object>();
        data.put("userId", userId);
        return tokenHelperIfs.issueAccessToken(data);

    }

    public Long validationToken(String token){
        var map = tokenHelperIfs.validationTokenWithThrow(token);
        var userId = map.get("userId");
        Objects.requireNonNull(userId, () ->{throw new ApiException(ErrorCode.NULL_POINT);});
        return Long.parseLong(userId.toString());


    }
}
