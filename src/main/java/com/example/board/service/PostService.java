package com.example.board.service;

import com.example.board.domain.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    //게시글 여러 개를 저장하는 임시 저장소
    private final List<Post> posts = new ArrayList<>();
    //새 게시글이 만들어질 때 사용할 번호
    private Long nextId = 1L;

    //게시글 생성 메서드
    public Post createPost(Post post) {

        Post newPost = new Post(
                nextId,
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );

        posts.add(newPost);
        nextId++;

        return newPost;
    }

    //게시글 조회 메서드
    public List<Post> getPosts() {
        return posts;
    }
}