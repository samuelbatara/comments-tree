package com.samuelbatara.util;

import com.samuelbatara.model.Comment;
import com.samuelbatara.model.CommentTree;

import java.util.Collections;
import java.util.List;

public class CommentTreeUtil {
  public boolean child(CommentTree tree, Comment comment) {
    if (tree.getComment().getId() == comment.getReplyTo()) {
      return true;
    }

    for (CommentTree commentTree : tree.getRepliedBy()) {
      if (child(commentTree, comment)) {
        return true;
      }
    }

    return false;
  }

  public boolean addChild(CommentTree tree, Comment child) {
    if (tree.getComment().getId() == child.getReplyTo()) {
      tree.addChild(createCommentTree(child));
      return true;
    }

    for (CommentTree commentTree : tree.getRepliedBy()) {
      if (addChild(commentTree, child)) {
        return true;
      }
    }

    return false;
  }

  private CommentTree createCommentTree(Comment comment) {
    return new CommentTree(comment);
  }

  public CommentTree buildCommentTree(List<Comment> comments) {
    Collections.sort(comments);

    Comment head = new Comment(0l, 0l, 0l, null, null);
    CommentTree tree = new CommentTree(head);

    for (Comment comment : comments) {
      if (comment.getReplyTo() == null) {
        comment.setReplyTo(0l);
      }
    }

    for (Comment comment : comments) {
      boolean result = addChild(tree, comment);

      assert result : "Failed to add child to head tree";
    }

    return tree;
  }
}
