package com.rentmarket.backend.domain.board.service;


import com.rentmarket.backend.db.board.Board;
import com.rentmarket.backend.db.board.BoardRepository;
import com.rentmarket.backend.db.user.User;
import com.rentmarket.backend.domain.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
//    private final JwtUtils jwtUtils;
//
//
//    public BoardService(BoardRepository boardRepository, JwtUtils jwtUtils) {
//        this.boardRepository = boardRepository;
//        this.jwtUtils = jwtUtils;
//    }

    // 전체 게시물 조회
    @Transactional(readOnly = true)
    public List<BoardDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        List<BoardDto> boardDtos = new ArrayList<>();
        boards.forEach(s -> boardDtos.add(BoardDto.toDto(s)));
        return boardDtos;
    }

    // 개별 게시물 조회
    @Transactional(readOnly = true)
    public BoardDto getBoard(int id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다.");
        });
        BoardDto boardDto = BoardDto.toDto(board);
        return boardDto;
    }

    // 게시물 작성
    @Transactional
    public BoardDto write(BoardDto boardDto, User user) {
        Board board = new Board();
        board.setCategory(boardDto.getCategory());
        board.setTitle(boardDto.getTitle());
        board.setThumbnailUrl(boardDto.getThumbnailUrl());
        board.setContent(boardDto.getContent());
        board.setPrice(boardDto.getPrice());
        board.setCreatedAt(boardDto.getCreatedAt());
        board.setStatus(boardDto.getStatus());

        // User 객체에서 가져온 정보
        board.setUsername(user.getUsername());
        board.setLocation(user.getLocation());

        boardRepository.save(board);
        return BoardDto.toDto(board);
    }

    // 게시물 수정
    @Transactional
    public BoardDto update(int id, BoardDto boardDto) {
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());

        return BoardDto.toDto(board);
    }


    // 게시글 삭제
    @Transactional
    public void delete(int id) {
        // 매개변수 id를 기반으로, 게시글이 존재하는지 먼저 찾음
        // 게시글이 없으면 오류 처리
        Board board = boardRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("Board Id를 찾을 수 없습니다!");
        });

        // 게시글이 있는 경우 삭제처리
        boardRepository.deleteById(id);

    }
}