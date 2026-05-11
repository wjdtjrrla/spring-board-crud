package com.example.board.exception;

/*
 * PostNotFoundException
 *
 * 게시글을 찾을 수 없을 때 사용할 사용자 정의 예외 클래스.
 *
 * RuntimeException을 상속하면
 * 별도의 throws 선언 없이 예외를 발생시킬 수 있다.
 */
public class PostNotFoundException extends RuntimeException {

    /*
     * 예외 메시지를 부모 클래스(RuntimeException)에 전달한다.
     */
    public PostNotFoundException(String message) {
        super(message);
    }
}