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
public class StoryLike {
  
  private Integer id;
  private Story story;
  private User user;
  private Instant createdDate;

}
