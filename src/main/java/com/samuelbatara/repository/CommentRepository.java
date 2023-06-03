package com.samuelbatara.repository;

import com.samuelbatara.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  @Query("SELECT c FROM Comment c where c.postId = ?1")
  List<Comment> findByPostId(long post_id);
}
