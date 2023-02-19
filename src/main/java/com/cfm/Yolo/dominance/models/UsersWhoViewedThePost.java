package com.cfm.Yolo.dominance.models;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersWhoViewedThePost {
  
  private Integer id;
  private Post post;
  private Set<User> users = new LinkedHashSet<>();
  private Instant visualizedDate;

}
