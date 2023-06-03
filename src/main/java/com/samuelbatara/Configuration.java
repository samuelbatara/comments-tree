package com.samuelbatara;

import com.samuelbatara.repository.CommentRepository;
import com.samuelbatara.repository.PostRepository;
import com.samuelbatara.service.CommentService;
import com.samuelbatara.service.CommentServiceImpl;
import com.samuelbatara.service.PostService;
import com.samuelbatara.service.PostServiceImpl;
import com.samuelbatara.util.CommentTreeUtil;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

  @Bean
  public CommentService commentService(CommentRepository commentRepository) {
    return new CommentServiceImpl(commentRepository, new CommentTreeUtil());
  }

  @Bean
  public PostService postService(PostRepository postRepository,
                                 CommentService commentService) {
    return new PostServiceImpl(postRepository, commentService);
  }
}
