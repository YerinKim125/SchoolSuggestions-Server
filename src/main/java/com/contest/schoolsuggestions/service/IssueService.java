package com.contest.schoolsuggestions.service;

import com.contest.schoolsuggestions.controller.IssueInfoTO;
import com.contest.schoolsuggestions.controller.PostInfoTO;
import com.contest.schoolsuggestions.controller.WriteIssueTO;
import com.contest.schoolsuggestions.controller.WritePostTO;
import com.contest.schoolsuggestions.domain.Issue;
import com.contest.schoolsuggestions.domain.Post;
import com.contest.schoolsuggestions.repository.IssueRepository;
import com.contest.schoolsuggestions.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IssueService {

    private final IssueRepository issueRepository;
    private final PostRepository postRepository;

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

    public PostInfoTO writePost(Long id, WritePostTO writePostTO) {
        Post post = Post.builder()
                .userId(writePostTO.getUserId())
                .issueId(id)
                .title(writePostTO.getTitle())
                .content(writePostTO.getContent()).build();
        post = postRepository.save(post);
        return new PostInfoTO(post);
    }

    public List<PostInfoTO> getPostList(Long id) {
        List<Post> postList = postRepository.findAllByIssueIdOrderByIdDesc(id);
        return postList.stream().map(PostInfoTO::new).collect(Collectors.toList());
    }
}
