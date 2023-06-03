package com.samuelbatara.controller;

import com.samuelbatara.model.Post;
import com.samuelbatara.model.PostWithComments;
import com.samuelbatara.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/posts")
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getPosts() {
    return postService.getPosts();
  }

  @GetMapping(path = "{id}")
  public PostWithComments getPostWithComments(@PathVariable("id") long id) {
    return postService.getPostByIdWithComments(id);
  }
}
