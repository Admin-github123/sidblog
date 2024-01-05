package com.sidblog.blog.service.impl;

import com.sidblog.blog.entity.Post;
import com.sidblog.blog.exception.ResourceNotFoundEcxception;
import com.sidblog.blog.payload.PostDto;
import com.sidblog.blog.repository.PostRepository;
import com.sidblog.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savePost = postRepository.save(post);

        PostDto dto = new PostDto();
        dto.setTitle(savePost.getTitle());
        dto.setDescription(savePost.getDescription());
        dto.setContent(savePost.getContent());
        return dto;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    @Override
    public void deletePostById(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isPresent()) {
            postRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundEcxception("Record is not found with id:" + id);
        }

    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).get();
        PostDto  dto = this.createPost(postDto);

//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
//
//        Post updatePost = postRepository.save(post);
//        PostDto dto=new PostDto();
//        dto.setTitle(updatePost.getTitle());
//        dto.setDescription(updatePost.getDescription());
//        dto.setContent(updatePost.getContent());
       return dto;

    }

}
