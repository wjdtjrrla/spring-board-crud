package com.example.board.dto;

import com.example.board.domain.Post;

/*
 * PostResponseDto
 *
 * 클라이언트에게 게시글 데이터를 응답할 때 사용하는 DTO.
 *
 * Entity(Post)를 그대로 반환하지 않고,
 * 외부에 보여줄 데이터만 골라서 응답한다.
 */
public class PostResponseDto {

    // 게시글 id
    private Long id;

    // 게시글 제목
    private String title;

    // 게시글 내용
    private String content;

    // 작성자
    private String author;

    /*
     * Entity(Post)를 ResponseDto로 변환하는 생성자
     *
     * DB에서 조회한 Post 객체를 받아서
     * 클라이언트에게 보여줄 응답 객체로 바꾼다.
     */
    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }

    // getter 메서드들
    // Spring이 JSON 응답을 만들 때 사용한다.

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
}