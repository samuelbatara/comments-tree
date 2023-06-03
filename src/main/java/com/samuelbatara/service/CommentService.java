package com.samuelbatara.service;

import com.samuelbatara.model.Comment;
import com.samuelbatara.model.CommentTree;

public interface CommentService {
  Comment getCommentById(long id);

  CommentTree getCommentTreeByPostId(long post_id);

  void deleteCommentById(long id);
}
