package com.rentmarket.backend.db.board;

import com.rentmarket.backend.common.entity.BaseEntity;
import com.rentmarket.backend.db.board.enums.BoardCategory;
import com.rentmarket.backend.db.user.enums.UserStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
@SuperBuilder
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String location;

    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BoardCategory category;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String thumbnailUrl;

    @Column(nullable = false)
    private int price;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "removed", nullable = false)
    private boolean removed;


//    public PostEntity update(PostSaveRequest postRequest) {
//        this.title = postRequest.getTitle();
//        this.content = postRequest.getContent();
//        this.price = postRequest.getPrice();
//        return this;
//    }

    public void removePost() {
        this.removed = true;
    }

//    public void update(String content) {
//        this.content = content;
//
//    }

//    public void update(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }
}
