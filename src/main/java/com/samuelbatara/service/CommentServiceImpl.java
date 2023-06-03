package com.samuelbatara.service;

import com.samuelbatara.model.Comment;
import com.samuelbatara.model.CommentTree;
import com.samuelbatara.repository.CommentRepository;
import com.samuelbatara.util.CommentTreeUtil;

import java.util.List;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
  private final CommentRepository commentRepository;
  private final CommentTreeUtil commentTreeUtil;

  public CommentServiceImpl(CommentRepository commentRepository,
                            CommentTreeUtil commentTreeUtil) {
    this.commentRepository = commentRepository;
    this.commentTreeUtil = commentTreeUtil;
  }

  @Override
  public Comment getCommentById(long id) {
    Optional<Comment> optionalComment = commentRepository.findById(id);

    if (optionalComment.isEmpty()) {
      return null;
    }

    return optionalComment.get();
  }

  @Override
  public CommentTree getCommentTreeByPostId(long post_id) {
    List<Comment> comments = commentRepository.findByPostId(post_id);
    CommentTree commentTree = commentTreeUtil.buildCommentTree(comments);
    return commentTree;
  }

  @Override
  public void deleteCommentById(long id) {
    commentRepository.deleteById(id);
  }
}
