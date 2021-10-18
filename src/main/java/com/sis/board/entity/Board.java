package com.sis.board.entity;

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
/** 동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
/**
 * @Entity:
 * 해당 클래스가 테이블과 매핑되는 JPA의 엔티티 클래스임을 의미
 * Default: 클래스명(CamelCase), 테이블명(SnakeCase)
 * ex.) Table: user_role, Class: UserRole
 * 클래스명과 테이블 명이 다를 경우 @Table(name = "user_role")과 같이 name 속성을 이용해서 처리
 * */
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // PK

    private String title; // 제목

    private String content; // 내용

    private String writer; // 작성자

    private int hits; // 조회 수

    private char deleteYn; // 삭제 여부

    private LocalDateTime createdDate = LocalDateTime.now(); // 생성일

    private LocalDateTime modifiedDate; // 수정일

    @Builder
    public Board(String title, String content, String writer, int hits, char deleteYn) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.hits = hits;
        this.deleteYn = deleteYn;
    }

    public void update(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.modifiedDate = LocalDateTime.now();
    }

}