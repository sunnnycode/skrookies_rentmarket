package com.rentmarket.backend.db.user;

import com.rentmarket.backend.common.entity.BaseEntity;
import com.rentmarket.backend.db.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@SuperBuilder
public class UserEntity extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private int phoneNumber;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
