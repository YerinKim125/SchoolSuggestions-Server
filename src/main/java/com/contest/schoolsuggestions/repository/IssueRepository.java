package com.contest.schoolsuggestions.repository;

import com.contest.schoolsuggestions.domain.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
