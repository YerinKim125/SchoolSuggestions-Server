package com.contest.schoolsuggestions.controller;

import com.contest.schoolsuggestions.service.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/issues")
public class IssueController {

    private final IssueService issueService;

    @PostMapping
    public IssueInfoTO writeIssue(@RequestBody WriteIssueTO writeIssueTO) {
        return issueService.writeIssue(writeIssueTO);
    }

    @GetMapping
    public IssueInfoTO getIssue() {
        return issueService.getIssue();
    }

    @PostMapping(value = "/{id}")
    public PostInfoTO writePost(@PathVariable Long id, @RequestBody WritePostTO writePostTO) {
        return issueService.writePost(id, writePostTO);
    }

    @GetMapping(value = "/{id}")
    public List<PostInfoTO> getPostList(@PathVariable Long id) {
        return issueService.getPostList(id);
    }
}
