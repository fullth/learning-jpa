package com.sis.shortcut.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Shortcut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String writer;
    private int hits;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;

    @Builder
    public Shortcut(String name, String description, String writer, int hits) {
        this.name = name;
        this.description = description;
        this.writer = writer;
        this.hits = hits;
    }

    public void updateShortcut(String name, String description, String writer) {
        this.name = name;
        this.description = description;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }
}
