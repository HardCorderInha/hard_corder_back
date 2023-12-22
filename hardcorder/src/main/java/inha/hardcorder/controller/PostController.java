package inha.hardcorder.controller;

import inha.hardcorder.domain.Post;
import inha.hardcorder.dto.PostDto;
import inha.hardcorder.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/api/posts")
    public ResponseEntity<?> write(@RequestBody PostDto postDto) {
        PostDto save = postService.save(postDto);
        log.info("게시글 작성 성공 " + postDto.getTitle());
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping("api/posts/keywords")
    public ResponseEntity<List<Post>> getPostsByKeyword(@RequestParam String keyword) {
        List<Post> posts = postService.getPostsByKeyword(keyword);
        log.info("keyword 기반 필터링 성공 " + keyword);
        return ResponseEntity.ok(posts);
    }

    @GetMapping("api/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable("postId") Long postId) {
        PostDto postDto = postService.getPostsByID(postId);
        log.info("개별 게시글 조회 성공 " + postId);
        return ResponseEntity.ok(postDto);
    }

    @GetMapping("api/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        log.info("전체 게시글 조회 성공");
        List<PostDto> posts = postService.getAllPost();
        return ResponseEntity.ok(posts);
    }
}
