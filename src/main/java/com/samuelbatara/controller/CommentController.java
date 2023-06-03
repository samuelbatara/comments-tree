package com.samuelbatara.controller;

import com.samuelbatara.model.Comment;
import com.samuelbatara.repository.CommentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/comments")
public class CommentController {

  private final CommentRepository commentRepository;

  public CommentController(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  @GetMapping
  public List<Comment> getComments() {
    return commentRepository.findAll();
  }
}
