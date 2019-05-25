package com.contest.schoolsuggestions.repository;

import com.contest.schoolsuggestions.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
