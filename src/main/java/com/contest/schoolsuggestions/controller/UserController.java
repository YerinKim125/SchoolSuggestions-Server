package com.contest.schoolsuggestions.controller;

import com.contest.schoolsuggestions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserInfoTO registerUser(@RequestBody RegisterUserTO registerUserTO) {
        return userService.registerUser(registerUserTO);
    }
}
