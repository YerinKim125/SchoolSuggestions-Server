package com.contest.schoolsuggestions.service;

import com.contest.schoolsuggestions.controller.RegisterUserTO;
import com.contest.schoolsuggestions.controller.UserInfoTO;
import com.contest.schoolsuggestions.domain.User;
import com.contest.schoolsuggestions.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserInfoTO registerUser(RegisterUserTO registerUserTO) {
        User user = User.builder()
                .email(registerUserTO.getEmail())
                .password(registerUserTO.getPassword())
                .name(registerUserTO.getName())
                .studentInfo(registerUserTO.getStudentInfo()).build();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return new UserInfoTO(user.getId(), user.getName(), user.getStudentInfo());
    }
}
