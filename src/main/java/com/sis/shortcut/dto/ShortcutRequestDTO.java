package com.sis.shortcut.dto;

import com.sis.shortcut.entity.Shortcut;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ShortcutRequestDTO {

    private String name;
    private String description;
    private String writer;

    public Shortcut toEntity() {
        return Shortcut.builder()
                .name(name)
                .description(description)
                .writer(writer)
                .hits(0)
                .build();
    }
}
