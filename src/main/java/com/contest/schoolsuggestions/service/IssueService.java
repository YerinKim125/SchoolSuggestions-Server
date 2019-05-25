package com.contest.schoolsuggestions.service;

import com.contest.schoolsuggestions.controller.IssueInfoTO;
import com.contest.schoolsuggestions.controller.WriteIssueTO;
import com.contest.schoolsuggestions.domain.Issue;
import com.contest.schoolsuggestions.repository.IssueRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueInfoTO writeIssue(WriteIssueTO writeIssueTO) {
        Issue issue = new Issue(writeIssueTO.getTitle());
        issue = issueRepository.save(issue);
        return new IssueInfoTO(issue.getId(), issue.getTitle());
    }

    public IssueInfoTO getIssue() {
        List<Issue> issueList = issueRepository.findAll();
        IssueInfoTO issueInfoTO = new IssueInfoTO(0L, "");

        int size = issueList.size();
        if (size > 0) {
            Issue issue = issueList.get(issueList.size() - 1);
            issueInfoTO.setId(issue.getId());
            issueInfoTO.setTitle(issue.getTitle());
        }

        return issueInfoTO;
    }
}
