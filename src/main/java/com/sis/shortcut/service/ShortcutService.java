package com.sis.shortcut.service;

import com.sis.exception.CustomException;
import com.sis.exception.ErrorCode;
import com.sis.shortcut.dto.ShortcutRequestDTO;
import com.sis.shortcut.dto.ShortcutResponseDTO;
import com.sis.shortcut.entity.Shortcut;
import com.sis.shortcut.entity.ShortcutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShortcutService {
    private final ShortcutRepository shortcutRepository;

    /**
     * Search all shortcut list
     * */
    public List<ShortcutResponseDTO> findAll() {

        Sort sort = Sort.by(Direction.DESC, "id", "createdDate");
        List<Shortcut> shortcutList = shortcutRepository.findAll(sort);

        return shortcutList.stream().map(ShortcutResponseDTO::new).collect(Collectors.toList());
    }

    /**
     * Search shortcut by id
     * */
    public List<ShortcutResponseDTO> findShortcutById(final Long id) {

        List<Shortcut> shortcutList = shortcutRepository.findAllById(Collections.singleton(id));

        return shortcutList.stream().map(ShortcutResponseDTO::new).collect(Collectors.toList());
    }

    /**
     * Resister shortcut list
     * */
    @Transactional
    public String save(final ShortcutRequestDTO params) {
        Shortcut shortcut = shortcutRepository.save(params.toEntity());
        return shortcut.getId() + "번 단축어가 저장되었습니다.";
    }

    /**
     * Update shortcut
     * */
    @Transactional
    public List<ShortcutResponseDTO> update(final Long id, final ShortcutRequestDTO params) {

        Shortcut shortcut = shortcutRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        shortcut.updateShortcut(params.getName(), params.getDescription(), params.getWriter());

        return findShortcutById(id);
    }

    /**
     * Delete shortcut
     * */
    @Transactional
    public void deletePost(Long id) {
        Shortcut shortcut = shortcutRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(new CustomException(ErrorCode.POSTS_NOT_FOUND)));
        shortcutRepository.delete(shortcut);
    }
}
