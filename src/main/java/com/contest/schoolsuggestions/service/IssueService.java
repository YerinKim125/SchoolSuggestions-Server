package com.contest.schoolsuggestions.service;

import com.contest.schoolsuggestions.controller.IssueInfoTO;
import com.contest.schoolsuggestions.controller.WriteIssueTO;
import com.contest.schoolsuggestions.domain.Issue;
import com.contest.schoolsuggestions.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueInfoTO writeIssue(WriteIssueTO writeIssueTO) {
        Issue issue = new Issue(writeIssueTO.getTitle());
        issue = issueRepository.save(issue);
        return new IssueInfoTO(issue.getId(), issue.getTitle());
    }
}
