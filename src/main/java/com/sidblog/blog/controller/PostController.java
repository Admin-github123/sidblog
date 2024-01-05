package com.sidblog.blog.controller;

import com.sidblog.blog.entity.Post;
import com.sidblog.blog.payload.PostDto;
import com.sidblog.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<?>getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("Record is Deleted!!",HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updatePost(@RequestParam long id,@RequestBody PostDto postDto){
       PostDto dto=postService.updatePost( id,postDto);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
