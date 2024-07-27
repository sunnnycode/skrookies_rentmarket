package com.rentmarket.backend.domain.user.controller;


import com.rentmarket.backend.common.api.Api;
import com.rentmarket.backend.domain.user.business.UserBusiness;
import com.rentmarket.backend.domain.user.controller.model.UserLoginRequest;
import com.rentmarket.backend.domain.user.controller.model.UserRegisterRequest;
import com.rentmarket.backend.domain.user.controller.model.UserResponse;
import com.rentmarket.backend.domain.user.token.controller.model.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequiredArgsConstructor
@RestController
@RequestMapping("/open-api/user")
public class UserOpenApiController {

    private final UserBusiness userBusiness;

    // 사용자 가입 요청
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ) {
        var response = userBusiness.register(request.getBody());
        return Api.OK(response);
    }

    // 로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
        @Valid
        @RequestBody Api<UserLoginRequest> request
    ){
        var response = userBusiness.login(request.getBody());
        return Api.OK(response);
    }
}
