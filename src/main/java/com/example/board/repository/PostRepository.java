package com.example.board.repository;

import com.example.board.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * PostRepository
 *
 * DB에 접근하는 역할 담당
 *
 * JpaRepository<Post, Long> 의미:
 * - Post: 어떤 Entity를 다룰 것인가?
 * - Long: Post Entity의 id 타입은 무엇인가?
 *
 * Spring Data JPA가 기본 CRUD 메서드를 자동 제공
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}