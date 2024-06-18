package com.yashpawar5.User.Registration.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authorities",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "authority"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(nullable = false)
    private String username;

    @Column(length = 50, nullable = false)
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
