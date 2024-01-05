package com.sidblog.blog.controller;

import com.sidblog.blog.entity.Post;
import com.sidblog.blog.payload.PostDto;
import com.sidblog.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        PostDto dto=postService.createPost(postDto);
       return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
