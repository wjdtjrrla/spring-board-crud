package com.example.board.controller;

import com.example.board.domain.Post;
import com.example.board.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
    /*
     * 게시글 전체 조회 API
     *
     * GET /api/posts/{id}
     */
    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }
    /*
     * 게시글 단건 조회 API
     *
     * GET /api/posts/{id}
     */
    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
    /*
     * 게시글 수정 API
     *
     * PUT /api/posts/{id}
     */
    @PutMapping("/{id}")
    public Post updatePost(
            @PathVariable Long id,
            @RequestBody Post updatedPost
    ) {
        return postService.updatePost(id, updatedPost);
    }

    /*
     * 게시글 삭제 API
     *
     * DELETE /api/posts/{id}
     */
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "삭제 완료";
    }
}