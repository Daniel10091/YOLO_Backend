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
public class Post {
  
  private Integer id;
  private User user;
  private byte[] content;
  private String title;
  private String description;
  private Set<UsersWhoViewedThePost> usersWhoViewedThePost = new LinkedHashSet<>();
  private Set<PostLike> postLikes = new LinkedHashSet<>();
  private Instant createdDate;

}
