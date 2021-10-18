package com.sis.shortcut.dto;

import com.sis.shortcut.entity.Shortcut;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShortcutResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String writer;
    private int hits;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;

    public ShortcutResponseDTO(Shortcut shortcut) {
        this.id = shortcut.getId();
        this.name = shortcut.getName();
        this.description = shortcut.getDescription();
        this.writer = shortcut.getWriter();
        this.hits = shortcut.getHits();
        this.createdDate = shortcut.getCreatedDate();
        this.modifiedDate = shortcut.getModifiedDate();
    }
}
