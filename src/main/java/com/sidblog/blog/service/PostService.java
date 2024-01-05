package com.sidblog.blog.service;


import com.sidblog.blog.payload.PostDto;

public interface PostService {
   PostDto  createPost(PostDto postDto);
}
