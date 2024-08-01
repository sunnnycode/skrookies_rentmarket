package com.rentmarket.backend.domain.board.controller;

import com.rentmarket.backend.db.board.enums.BoardCategory;
import com.rentmarket.backend.db.user.User;
import com.rentmarket.backend.db.user.UserRepository;
import com.rentmarket.backend.db.user.enums.UserStatus;
import com.rentmarket.backend.domain.board.dto.BoardDto;
import com.rentmarket.backend.domain.board.response.Response;
import com.rentmarket.backend.domain.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {


    private final BoardService boardService;
    private final UserRepository userRepository;


    // 전체 게시글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards")
    public Response getBoards() {
        return new Response("성공", "전체 게시물 리턴", boardService.getBoards());
    }



    // 개별 게시글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards/{id}")
    public Response getBoard(@PathVariable("id") Integer id) {
        return new Response("성공", "개별 게시물 리턴", boardService.getBoard(id));
    }



    // 게시글 작성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/boards/write")
    public Response write(@RequestBody BoardDto boardDto) {

        // findById로 유저 정보 임의 주입
        User user = userRepository.findById(3).get();
        return new Response("성공", "글 작성 성공", boardService.write(boardDto, user));
    }



    // 게시글 수정
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/boards/update/{id}")
    public Response edit(@RequestBody BoardDto boardDto, @PathVariable("id") Integer id) {

        User user = userRepository.findById(3).get();
        return new Response("성공", "글 수정 성공", boardService.update(id, boardDto));
    }




    // 게시글 삭제
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/boards/delete/{id}")
    public Response delete(@PathVariable("id") Integer id) {

        boardService.delete(id); // 이 메소드는 반환값이 없으므로 따로 삭제 수행해주고, 리턴에는 null을 넣어줌
        return new Response("성공", "글 삭제 성공", null);
    }
}