package com.example.board.dto;

/*
 * ApiResponseDto
 *
 * API 응답 형식을 통일하기 위한 DTO.
 *
 * 기존에는 API마다 응답 형태가 달랐다.
 * 예:
 * - 게시글 조회: PostResponseDto
 * - 삭제: "삭제 완료"
 * - 에러: "게시글을 찾을 수 없습니다."
 *
 * 이제는 모든 응답을 아래 구조로 통일한다.
 *
 * {
 *   "success": true,
 *   "message": "요청 성공",
 *   "data": ...
 * }
 */
public class ApiResponseDto<T> {

    /*
     * 요청 성공 여부
     * 성공이면 true, 실패면 false
     */
    private boolean success;

    /*
     * 응답 메시지
     */
    private String message;

    /*
     * 실제 응답 데이터
     *
     * T는 제네릭 타입이다.
     * 즉, data에 들어갈 타입을 상황에 따라 다르게 받을 수 있다.
     *
     * 예:
     * - PostResponseDto
     * - List<PostResponseDto>
     * - null
     */
    private T data;

    /*
     * 생성자
     */
    public ApiResponseDto(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    /*
     * 성공 응답을 쉽게 만들기 위한 정적 메서드
     *
     * 사용 예:
     * ApiResponseDto.success("게시글 생성 성공", responseDto)
     */
    public static <T> ApiResponseDto<T> success(String message, T data) {
        return new ApiResponseDto<>(true, message, data);
    }

    /*
     * 실패 응답을 쉽게 만들기 위한 정적 메서드
     *
     * 사용 예:
     * ApiResponseDto.fail("게시글을 찾을 수 없습니다.")
     */
    public static <T> ApiResponseDto<T> fail(String message) {
        return new ApiResponseDto<>(false, message, null);
    }

    /*
     * getter
     *
     * Spring이 JSON 응답을 만들 때 getter를 사용한다.
     */
    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}