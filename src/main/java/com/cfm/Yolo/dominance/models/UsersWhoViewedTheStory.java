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
public class UsersWhoViewedTheStory {
  
  private Integer id;
  private Story story;
  private Set<User> users = new LinkedHashSet<>();
  private Instant visalizedDate;
  
}
