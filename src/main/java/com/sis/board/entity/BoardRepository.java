package com.sis.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MyBatis의 Mapper와 유사함. 퍼시스턴스 영역에 사용되는 인터페이스
 * 엔티티 클래스와 레파지토리 인터페이스는 꼭 같은 패키지에 위치해야 함
 * */
public interface BoardRepository extends JpaRepository<Board, Long> {

}
