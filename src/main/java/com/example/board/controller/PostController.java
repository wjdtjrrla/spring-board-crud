package com.example.board.controller;

import com.example.board.dto.ApiResponseDto;
import com.example.board.dto.PostRequestDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.service.PostService;
import org.springframework.web.bind.annotation.*;

//데이터 검증 라이브러리
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    /*
     * 게시글 생성 API
     *
     * POST /api/posts
     */
    @PostMapping
    public ApiResponseDto<PostResponseDto> createPost(
            @Valid @RequestBody PostRequestDto requestDto
    ) {
        PostResponseDto responseDto = postService.createPost(requestDto);

        return ApiResponseDto.success("게시글 생성 성공", responseDto);
    }
    /*
     * 게시글 전체 조회 API
     *
     * GET /api/posts
     */
    @GetMapping
    public ApiResponseDto<List<PostResponseDto>> getPosts() {
        List<PostResponseDto> responseDtos = postService.getPosts();

        return ApiResponseDto.success("게시글 전체 조회 성공", responseDtos);
    }
    /*
     * 게시글 단건 조회 API
     *
     * GET /api/posts/{id}
     */
    @GetMapping("/{id}")
    public ApiResponseDto<PostResponseDto> getPost(@PathVariable Long id) {
        PostResponseDto responseDto = postService.getPost(id);

        return ApiResponseDto.success("게시글 단건 조회 성공", responseDto);
    }

    /*
     * 게시글 수정 API
     *
     * PUT /api/posts/{id}
     */
    @PutMapping("/{id}")
    public ApiResponseDto<PostResponseDto> updatePost(
            @PathVariable Long id,
            @Valid @RequestBody PostRequestDto requestDto
    ) {
        PostResponseDto responseDto = postService.updatePost(id, requestDto);

        return ApiResponseDto.success("게시글 수정 성공", responseDto);
    }

    /*
     * 게시글 삭제 API
     *
     * DELETE /api/posts/{id}
     *
     * 삭제는 반환할 데이터가 없기 때문에 data는 null로 둔다.
     */
    @DeleteMapping("/{id}")
    public ApiResponseDto<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);

        return ApiResponseDto.success("게시글 삭제 성공", null);
    }
}