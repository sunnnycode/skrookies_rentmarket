//package com.rentmarket.backend.domain.comment.dto;
//
//import com.rentmarket.backend.db.comment.Comment;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class CommentDto {
//    private int id;
//    private String content;
//    private String writer;
//
//    public static CommentDto toDto(Comment comment) {
//        return new CommentDto(
//                comment.getId(),
//                comment.getContent(),
//                comment.getUser().getUsername()
//        );
//    }
//}