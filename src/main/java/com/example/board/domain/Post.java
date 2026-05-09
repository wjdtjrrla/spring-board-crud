package com.example.board.domain;

public class Post {

    private Long id; //외부에서 직접 값을 바꾸지 못하게 private
    private String title;
    private String content;
    private String author;

    public Post() {
    }

    public Post(Long id, String title, String content, String author) { //생성자로 게시글 객체
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void update(String title, String content) { //게시글 수정할 때 사용
        this.title = title;
        this.content = content;
    }
}