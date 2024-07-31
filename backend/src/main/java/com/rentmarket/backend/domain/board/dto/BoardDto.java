package com.rentmarket.backend.domain.board.dto;

import com.rentmarket.backend.db.board.Board;
import com.rentmarket.backend.db.board.enums.BoardCategory;
import com.rentmarket.backend.db.user.enums.UserStatus;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String location;

    @NotNull
    private BoardCategory category;

    @NotNull
    private String title;

    @NotNull
    private String thumbnailUrl;

    @NotNull
    private int price;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
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
