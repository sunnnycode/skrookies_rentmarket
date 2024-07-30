package com.rentmarket.backend.db.board;

import com.rentmarket.backend.db.board.enums.BoardCategory;
import com.rentmarket.backend.db.board.enums.BoardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 유효한 특정 카테고리의 스토어 리스트
    List<Board> findAllByStatusAndCategoryOrderByIdDesc(BoardStatus status, BoardCategory category);
}
