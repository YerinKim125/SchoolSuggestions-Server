package com.contest.schoolsuggestions.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdatePostTO {

    private Integer agree;
    private Integer disagree;
    private String feedback;
}
