package com.samuelbatara.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Comparable<Comment> {
  @Id
  private Long id;
  private Long postId;
  private Long replyTo;
  private String body;
  private Date postedDate;

  @Override
  public int compareTo(Comment comment) {
    return this.id.compareTo(comment.getId());
  }
}
