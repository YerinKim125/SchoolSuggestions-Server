package com.contest.schoolsuggestions.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class WritePostTO {

    private Long userId;
    private String title;
    private String content;
}
