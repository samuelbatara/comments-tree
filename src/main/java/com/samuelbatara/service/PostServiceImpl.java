package com.samuelbatara.service;

import com.samuelbatara.model.CommentTree;
import com.samuelbatara.model.Post;
import com.samuelbatara.model.PostWithComments;
import com.samuelbatara.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final CommentService commentService;

  public PostServiceImpl(PostRepository postRepository,
                         CommentService commentService) {
    this.postRepository = postRepository;
    this.commentService = commentService;
  }

  @Override
  public List<Post> getPosts() {
    return postRepository.findAll();
  }

  @Override
  public Post getPostById(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);

    if (optionalPost.isEmpty()) {
      return null;
    }

    return optionalPost.get();
  }

  @Override
  public PostWithComments getPostByIdWithComments(long id) {
    Optional<Post> optionalPost = postRepository.findById(id);
    if (optionalPost.isEmpty()) {
      return null;
    }

    CommentTree commentTree = commentService.getCommentTreeByPostId(id);
    PostWithComments postWithComments = new PostWithComments(optionalPost.get(), commentTree);
    return postWithComments;
  }

  @Override
  public void deletePostById(long id) {
    postRepository.deleteById(id);
  }
}
