package com.rentmarket.backend.domain.user.controller;

import com.rentmarket.backend.common.annotation.UserSession;
import com.rentmarket.backend.common.api.Api;
import com.rentmarket.backend.domain.user.business.UserBusiness;

import com.rentmarket.backend.domain.user.dto.UserDto;

import com.rentmarket.backend.domain.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserBusiness userBusiness;

    @GetMapping("/me")
    public Api<UserResponse> me(
            @UserSession UserDto userDto
    ){
        var response = userBusiness.me(userDto);
        return Api.OK(response);
    }
}