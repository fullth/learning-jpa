package com.sis.board;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.sis.board.entity.Board;
import com.sis.board.entity.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTests {

    @Autowired
    BoardRepository boardRepository;

    @Test
    void save() {

        // 1. 게시글 파라미터 생성
        Board params = Board.builder()
                .title("게시판 등록 테스트")
                .content("JPA를 이용한 게시판, 등록 테스트 입니다.")
                .writer("fullth")
                .hits(0)
                .deleteYn('N')
                .build();

        // 2. 게시글 저장
        boardRepository.save(params);

        // 3. 1번 게시글 정보 조회
        Board entity = boardRepository.findById((long) 2).get();
        assertThat(entity.getTitle()).isEqualTo("게시판 등록 테스트");
        assertThat(entity.getContent()).isEqualTo("JPA를 이용한 게시판, 등록 테스트 입니다.");
        assertThat(entity.getWriter()).isEqualTo("fullth");
    }

    @Test
    void findAll() {

        // 1. 전체 게시글 수 조회
        long boardsCount = boardRepository.count();

        // 2. 전체 게시글 리스트 조회
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {

        // 1. 게시글 조회
        Board entity = boardRepository.findById((long) 1).get();

        // 2. 게시글 삭제
        boardRepository.delete(entity);
    }

}