package com.cfm.Yolo.dominance.models;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostLike {
  
  private Integer id;
  private Post post;
  private User user;
  private byte[] icon;
  private Instant createdDate;

}
