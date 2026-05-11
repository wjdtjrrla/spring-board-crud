package com.example.board.dto;

import jakarta.validation.constraints.NotBlank;

/*
 * PostRequestDto
 *
 * 클라이언트가 게시글 생성/수정 요청을 보낼 때 사용하는 DTO.
 * 요청 데이터 검증도 이 DTO에서 처리한다.
 */
public class PostRequestDto {

    /*
     * @NotBlank
     *
     * null, 빈 문자열(""), 공백("   ")을 허용하지 않는다.
     * 즉, 제목은 반드시 입력되어야 한다.
     */
    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    /*
     * 내용도 반드시 입력되어야 한다.
     */
    @NotBlank(message = "내용은 필수입니다.")
    private String content;

    /*
     * 작성자도 반드시 입력되어야 한다.
     */
    @NotBlank(message = "작성자는 필수입니다.")
    private String author;

    /*
     * 기본 생성자
     *
     * Spring이 JSON 데이터를 객체로 변환할 때 필요하다.
     */
    public PostRequestDto() {
    }

    public PostRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
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