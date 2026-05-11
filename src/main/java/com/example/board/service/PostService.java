package com.example.board.service;

//데이터베이스에 변환하기 이전 : LIST 테스트 코드

/*
import com.example.board.domain.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class PostService {

    //게시글 여러 개를 저장하는 임시 저장소
    private final List<Post> posts = new ArrayList<>();
    //새 게시글이 만들어질 때 사용할 번호
//    private Long nextId = 1L;

    //게시글 생성 메서드
    public Post createPost(Post post) {

        // ID는
        Post newPost = new Post(
//                nextId,
                post.getTitle(),
                post.getContent(),
                post.getAuthor()
        );

        posts.add(newPost);
//        nextId++;

        return newPost;
    }

    //게시글 조회 메서드
    public List<Post> getPosts() {

        return posts;
    }
}

*/

//3일차까지 코드 : DTO 사용 이전
/*

import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;


//     * @Service
//     *
//     * 이 클래스가 비즈니스 로직을 담당하는 Service 계층.
//     * Controller는 요청을 받고, 실제 게시글 저장/조회 같은 처리는 Service가 담당.

@Service
public class PostService {


//     * PostRepository는 DB에 접근하는 객체다.
//     * final:
//     * - 한 번 주입받은 repository를 바꾸지 않겠다는 의미

    private final PostRepository postRepository;


//     * 생성자 주입
//     *
//     * Spring이 PostRepository 객체를 자동으로 넣어준다.
//     * 이것을 DI, 의존성 주입.

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


//     * 게시글 생성
//     *
//     * Controller에서 받은 Post 객체를 DB에 저장.
//     * save()는 JpaRepository가 제공하는 메서드.

    public Post createPost(Post post) {
        return postRepository.save(post);
    }


//     * 게시글 전체 조회
//     *
//     * DB에 저장된 모든 게시글을 조회.
//     * findAll()도 JpaRepository가 제공.

    public List<Post> getPosts() {
        return postRepository.findAll();
    }


//     * 게시글 단건 조회
//     *
//     * findById(id)는 id 값으로 게시글을 찾는다.
//     * 만약 게시글이 없으면 RuntimeException을 발생.

    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }


//     * 게시글 수정
//     *
//     * 1. id로 기존 게시글 서칭.
//     * 2. 찾은 게시글의 title, content를 변경.
//     * 3. save()로 DB에 다시 저장.
//     * 4. 없으면 RuntimeException

    public Post updatePost(Long id, Post updatedPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        post.update(updatedPost.getTitle(), updatedPost.getContent());

        return postRepository.save(post);
    }


//     * 게시글 삭제
//     *
//     * 1. id로 게시글 서칭.
//     * 2. 존재하면 삭제.
//     * 3. 없으면 RuntimeException

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        postRepository.delete(post);
    }
}
 */

//4일차 : DTO 사용하도록 코드 변경

import com.example.board.domain.Post;
import com.example.board.dto.PostRequestDto;
import com.example.board.dto.PostResponseDto;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;
import com.example.board.exception.PostNotFoundException;

import java.util.List;
import java.util.stream.Collectors;


// * PostService
// *
// * 게시글 관련 비즈니스 로직을 담당하는 계층
// * Controller는 요청을 받고,
// * Service는 실제 저장/조회/수정/삭제 로직을 처리

@Service
public class PostService {


//     * PostRepository는 DB와 직접 연결되는 객체
//     * Service는 Repository를 통해 DB에 접근

    private final PostRepository postRepository;


//     * 생성자 주입
//     *
//     * Spring이 PostRepository 객체를 자동으로 넣어준다.

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


//     * 게시글 생성
//     *
//     * Controller에서 PostRequestDto를 전달받는다.
//     * DTO는 요청 데이터용 객체이고,
//     * DB에 저장할 때는 Entity(Post)로 변환해야 한다.

    public PostResponseDto createPost(PostRequestDto requestDto) {

        // 요청 DTO → Entity 변환
        Post post = new Post(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor()
        );

        // Entity를 DB에 저장
        Post savedPost = postRepository.save(post);

        // 저장된 Entity → 응답 DTO 변환
        return new PostResponseDto(savedPost);
    }


//     * 게시글 전체 조회
//     *
//     * DB에서 Post Entity 목록을 조회한 뒤,
//     * 각각 PostResponseDto로 변환해서 반환한다.

    public List<PostResponseDto> getPosts() {

        List<Post> posts = postRepository.findAll();

        return posts.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }


//     * 게시글 단건 조회
//     *
//     * id로 Entity를 찾고,
//     * 찾은 Entity를 ResponseDto로 변환해서 반환한다.

    public PostResponseDto getPost(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));

        return new PostResponseDto(post);
    }


//     * 게시글 수정
//     *
//     * 1. id로 기존 게시글 Entity를 찾는다.
//     * 2. RequestDto의 값으로 Entity를 수정한다.
//     * 3. 수정된 Entity를 저장한다.
//     * 4. ResponseDto로 변환해서 반환한다.

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));

        post.update(
                requestDto.getTitle(),
                requestDto.getContent()
        );

        Post updatedPost = postRepository.save(post);

        return new PostResponseDto(updatedPost);
    }


//     * 게시글 삭제
//     *
//     * id로 게시글을 찾은 뒤 삭제한다.

    public void deletePost(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("게시글을 찾을 수 없습니다."));

        postRepository.delete(post);
    }
}