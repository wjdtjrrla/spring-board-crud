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

import com.example.board.domain.Post;
import com.example.board.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Service
 *
 * 이 클래스가 비즈니스 로직을 담당하는 Service 계층.
 * Controller는 요청을 받고, 실제 게시글 저장/조회 같은 처리는 Service가 담당.
 */
@Service
public class PostService {

    /*
     * PostRepository는 DB에 접근하는 객체다.
     * final:
     * - 한 번 주입받은 repository를 바꾸지 않겠다는 의미
     */
    private final PostRepository postRepository;

    /*
     * 생성자 주입
     *
     * Spring이 PostRepository 객체를 자동으로 넣어준다.
     * 이것을 DI, 의존성 주입.
     */
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /*
     * 게시글 생성
     *
     * Controller에서 받은 Post 객체를 DB에 저장.
     * save()는 JpaRepository가 제공하는 메서드.
     */
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    /*
     * 게시글 전체 조회
     *
     * DB에 저장된 모든 게시글을 조회.
     * findAll()도 JpaRepository가 제공.
     */
    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    /*
     * 게시글 단건 조회
     *
     * findById(id)는 id 값으로 게시글을 찾는다.
     * 만약 게시글이 없으면 RuntimeException을 발생.
     */
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
    }

    /*
     * 게시글 수정
     *
     * 1. id로 기존 게시글 서칭.
     * 2. 찾은 게시글의 title, content를 변경.
     * 3. save()로 DB에 다시 저장.
     * 4. 없으면 RuntimeException
     */
    public Post updatePost(Long id, Post updatedPost) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        post.update(updatedPost.getTitle(), updatedPost.getContent());

        return postRepository.save(post);
    }

    /*
     * 게시글 삭제
     *
     * 1. id로 게시글 서칭.
     * 2. 존재하면 삭제.
     * 3. 없으면 RuntimeException
     */
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        postRepository.delete(post);
    }
}