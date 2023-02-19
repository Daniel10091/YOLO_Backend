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
public class User {
  
  private Integer id;
  private Person person;
  private byte[] avatar;
  private byte[] background;
  private String username;
  private String salt;
  private String password;
  private Boolean isActive;
  private Instant createdDate;
  private Set<Friend> friends;
  private Set<Message> messages = new LinkedHashSet<>();
  private Set<MessageLike> messagesLikes = new LinkedHashSet<>();
  private Set<Post> posts = new LinkedHashSet<>();
  private Set<PostLike> postsLikes = new LinkedHashSet<>();
  private Set<Story> stories = new LinkedHashSet<>();
  private Set<StoryLike> storyLikes = new LinkedHashSet<>();

}
