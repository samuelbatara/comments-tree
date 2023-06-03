package com.samuelbatara.model;

import java.util.ArrayList;
import java.util.List;

public class CommentTree {
  private Comment comment;
  private List<CommentTree> repliedBy;

  public CommentTree(Comment comment) {
    this.comment = comment;
    this.repliedBy = new ArrayList<>();
  }

  public Comment getComment() {
    return comment;
  }

  public List<CommentTree> getRepliedBy() {
    return repliedBy;
  }

  public void addChild(CommentTree child) {
    this.repliedBy.add(child);
  }
}
