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
public class Story {
  
  private Integer id;
  private User user;
  private byte[] content;
  private String title;
  private String messageText;
  private Set<UsersWhoViewedTheStory> usersWhoViewedTheStory = new LinkedHashSet<>();
  private Instant createdDate;

}
