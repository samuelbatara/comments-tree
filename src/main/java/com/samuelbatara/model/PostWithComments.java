package com.samuelbatara.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostWithComments {
  private final Post post;
  private final CommentTree commentTree;
}
