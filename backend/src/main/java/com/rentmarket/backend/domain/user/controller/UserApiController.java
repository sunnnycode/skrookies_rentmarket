package com.rentmarket.backend.domain.user.controller;

import com.rentmarket.backend.common.annotation.UserSession;
import com.rentmarket.backend.common.api.Api;
import com.rentmarket.backend.domain.user.business.UserBusiness;
import com.rentmarket.backend.domain.user.controller.model.UserResponse;
import com.rentmarket.backend.domain.user.model.User;
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
            @UserSession User user
    ){
        var response = userBusiness.me(user);
        return Api.OK(response);
    }
}
