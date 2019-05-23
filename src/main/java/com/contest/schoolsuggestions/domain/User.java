package com.contest.schoolsuggestions.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, columnDefinition = "varchar(50)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(20)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(5)")
    private String studentInfo;

    @Builder
    public User(Long id, String email, String password, String name, String studentInfo) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.studentInfo = studentInfo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
