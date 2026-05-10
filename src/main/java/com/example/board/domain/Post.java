package com.example.board.domain;

// JPA 관련 어노테이션 import
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/*
 * @Entity
 * 이 클래스가 DB 테이블과 연결되는 객체라는 의미
 */
@Entity
public class Post {
    /*
     * @Id
     * 테이블의 기본 키(PK)
     */
    @Id

    /*
     * @GeneratedValue
     * id 값을 DB가 자동으로 증가
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시글 제목
    private String title;

    // 게시글 내용
    private String content;

    // 작성자
    private String author;

    /*
     * 기본 생성자
     * JPA가 객체 생성 시 필요하다.
     * 반드시 있어야 한다.
     */
    public Post() {
    }

    /*
     * 게시글 생성용 생성자
     */
    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // getter 메서드들
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    /*
     * 게시글 수정 메서드
     */
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}