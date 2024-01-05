package com.sidblog.blog.service;


import com.sidblog.blog.entity.Post;
import com.sidblog.blog.payload.PostDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostService {
   PostDto  createPost(PostDto postDto);
   List<Post> getAllPosts();

   void deletePostById(long id);



   PostDto updatePost(long id, PostDto postDto);

}
