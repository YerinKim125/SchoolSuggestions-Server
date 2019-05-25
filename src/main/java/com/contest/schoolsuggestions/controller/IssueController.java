package com.contest.schoolsuggestions.controller;

import com.contest.schoolsuggestions.service.IssueService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
