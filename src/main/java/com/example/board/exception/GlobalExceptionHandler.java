package com.example.board.exception;

import com.example.board.dto.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * GlobalExceptionHandler
 *
 * 프로젝트 전체 예외를 공통으로 처리하는 클래스.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /*
     * 게시글을 찾을 수 없는 경우
     *
     * 404 Not Found 반환
     */
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Void>> handlePostNotFoundException(
            PostNotFoundException e
    ) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponseDto.fail(e.getMessage()));
    }

    /*
     * Validation 실패 처리
     *
     * 400 Bad Request 반환
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseDto<Void>> handleValidationException(
            MethodArgumentNotValidException e
    ) {
        String errorMessage = e.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponseDto.fail(errorMessage));
    }
}