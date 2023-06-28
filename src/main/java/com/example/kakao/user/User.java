package com.example.kakao.user;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="user_tb")
public class User{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email; // 인증시 필요한 필드

    @Column(name = "password", length = 256, nullable = false)
    private String password;

    @Column(name = "username", length = 45, nullable = false)
    private String username;

    @Column(length = 30)
    @Convert(converter = StringArrayConverter.class)
    private List<String> roles = new ArrayList<>(); // role은 한 개 이상

    @Column(name = "date", length = 45, nullable = false)
    private LocalDateTime date;

    @Builder
    public User(int userId, String email, String password, String username, List<String> roles, LocalDateTime date) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.username = username;
        this.roles = roles;
        this.date = date;
    }
}
