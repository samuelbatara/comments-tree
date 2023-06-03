package com.samuelbatara.service;

import com.samuelbatara.model.Post;
import com.samuelbatara.model.PostWithComments;

import java.util.List;

public interface PostService {
  List<Post> getPosts();
  Post getPostById(long id);
  PostWithComments getPostByIdWithComments(long id);
  void deletePostById(long id);
}
