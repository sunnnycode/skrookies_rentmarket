package com.rentmarket.backend.db.user;

import com.rentmarket.backend.common.entity.BaseEntity;
import com.rentmarket.backend.db.user.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@SuperBuilder
@Component
public class User extends BaseEntity {


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
    private String phoneNumber;

    @Column(nullable = false)
    private String location;


    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    // getter, setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
