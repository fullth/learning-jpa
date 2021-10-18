package com.sis.board.service;

import com.sis.board.entity.BoardRepository;
import com.sis.exception.CustomException;
import com.sis.exception.ErrorCode;
import com.sis.board.dto.BoardRequestDTO;
import com.sis.board.dto.BoardResponseDTO;
import com.sis.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
/**
 * Spring에선 생성자로 빈을 주입받는 것을 권하고 있음.
 * @RequiredArgsConstructor 어노테이션은 final로 생성된 모든 멤버에 대한 생성자를 생성해줌.
 * */
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    
    /**
     * 게시글 생성
     */
    @Transactional
    public Long save(final BoardRequestDTO params) {

        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * 게시글 리스트 조회
     */
    public List<BoardResponseDTO> findAll() {

        Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDTO::new).collect(Collectors.toList());
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Long update(final Long id, final BoardRequestDTO params) {

        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContent(), params.getWriter());
        return id;
    }

}
