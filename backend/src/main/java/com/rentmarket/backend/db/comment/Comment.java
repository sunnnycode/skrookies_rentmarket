//package com.rentmarket.backend.db.comment;
//
//import com.rentmarket.backend.db.board.Board;
//import com.rentmarket.backend.db.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//import org.springframework.data.annotation.Id;
//
//
//@Data
//@Table(name = "commment")
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//public class Comment {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private int id;
//
//    @Column(nullable = false)
//    private String content;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    @OnDelete(action = OnDeleteAction.CASCADE) // 연관된 user가 삭제되면 같이 삭제됨
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "board_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Board board;
//}