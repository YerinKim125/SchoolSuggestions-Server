package com.contest.schoolsuggestions.controller;

import com.contest.schoolsuggestions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/login")
    public ResponseEntity<UserInfoTO> login(@RequestBody LoginTO loginTO) {
        UserInfoTO userInfoTO = userService.login(loginTO);
        ResponseEntity<UserInfoTO> responseEntity;
        if (userInfoTO != null) {
            responseEntity = new ResponseEntity<>(userInfoTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(new UserInfoTO(0L, "", null), HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }
}
