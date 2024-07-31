package com.rentmarket.backend.domain.user.token.service;

import com.rentmarket.backend.common.error.ErrorCode;
import com.rentmarket.backend.common.exception.ApiException;
import com.rentmarket.backend.domain.user.token.Ifs.TokenHelperIfs;
import com.rentmarket.backend.domain.user.token.dto.TokenDto;
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

    public TokenDto issueAccessToken(String userName){
        var data = new HashMap<String, Object>();
        data.put("userName", userName);
        return tokenHelperIfs.issueAccessToken(data);

    }

    public TokenDto issueRefreshToken(String useeName){
        var data = new HashMap<String, Object>();
        data.put("userName", useeName);
        return tokenHelperIfs.issueAccessToken(data);

    }

    public Long validationToken(String token){
        var map = tokenHelperIfs.validationTokenWithThrow(token);
        var userName = map.get("userName");
        Objects.requireNonNull(userName, () ->{throw new ApiException(ErrorCode.NULL_POINT);});
        return Long.parseLong(userName.toString());


    }
}