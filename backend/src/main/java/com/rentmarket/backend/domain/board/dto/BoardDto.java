package com.rentmarket.backend.domain.board.dto;

import com.rentmarket.backend.db.board.Board;
import com.rentmarket.backend.db.board.enums.BoardCategory;
import com.rentmarket.backend.db.user.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class BoardDto {

    private int id;
    private String username;
    private String location;
    private BoardCategory category;
    private String title;
    private String thumbnailUrl;
    private int price;
    private String content;
    private LocalDateTime createdAt;
    private UserStatus status;

    public static BoardDto toDto(Board board) {
        return new BoardDto(
                board.getId(),
                board.getUsername(),
                board.getLocation(),
                board.getCategory(),
                board.getTitle(),
                board.getThumbnailUrl(),
                board.getPrice(),
                board.getContent(),
                board.getCreatedAt(),
                board.getStatus()
        );
    }
}
