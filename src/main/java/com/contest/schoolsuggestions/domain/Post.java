package com.contest.schoolsuggestions.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(name = "issue_id", columnDefinition = "bigint", nullable = false)
    private Long issueId;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer agree;

    @Column(columnDefinition = "int default 0", nullable = false, insertable = false)
    private Integer disagree;

    @Column(columnDefinition = "text")
    private String feedback;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "issue_id", updatable = false, insertable = false)
    private Issue issue;

    @Builder
    public Post(Long userId, Long issueId, String title, String content, Integer agree, Integer disagree) {
        this.userId = userId;
        this.issueId = issueId;
        this.title = title;
        this.content = content;
        this.agree = agree;
        this.disagree = disagree;
    }
}
