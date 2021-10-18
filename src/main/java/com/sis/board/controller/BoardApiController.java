package com.sis.board.controller;

import com.sis.board.service.BoardService;
import com.sis.exception.CustomException;
import com.sis.exception.ErrorCode;
import com.sis.board.dto.BoardRequestDTO;
import com.sis.board.dto.BoardResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("/test")
    public String test() {
        throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
    }

    /**
     * 게시글 생성
     */
    @PostMapping("/v1/boards")
    public Long save(@RequestBody final BoardRequestDTO params) {
        return boardService.save(params);
    }

    /**
     * 게시글 리스트 조회
     */
    @GetMapping("/v1/boards")
    public List<BoardResponseDTO> findAll() {
        return boardService.findAll();
    }

    /**
     * 게시글 수정
     */
    @PatchMapping("/v1/boards/{id}")
    public Long save(@PathVariable final Long id, @RequestBody final BoardRequestDTO params) {
        return boardService.update(id, params);
    }

}
