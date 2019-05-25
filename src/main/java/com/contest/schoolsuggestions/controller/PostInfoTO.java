package com.contest.schoolsuggestions.controller;

import com.contest.schoolsuggestions.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostInfoTO {

    private Long id;
    private String title;
    private String content;
    private Integer agree;
    private Integer disagree;
    private String feedback;

    public PostInfoTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.agree = post.getAgree();
        this.disagree = post.getDisagree();
        this.feedback = post.getFeedback();
    }
}
