package com.cfm.Yolo.infrastructure.adapters.entity;

import java.time.Instant;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {

  @Id
  private Integer id;
  @OneToOne(optional = true)
  @JoinColumn(name = "id")
  private PersonEntity person;
  private byte[] avatar;
  private byte[] background;
  private String username;
  private String salt;
  private String password;
  private Boolean isActive;
  private Instant createdDate;
  // private Set<Friend> friends;
  // private Set<Message> messages = new LinkedHashSet<>();
  // private Set<MessageLike> messagesLikes = new LinkedHashSet<>();
  // private Set<Post> posts = new LinkedHashSet<>();
  // private Set<PostLike> postsLikes = new LinkedHashSet<>();
  // private Set<Story> stories = new LinkedHashSet<>();
  // private Set<StoryLike> storyLikes = new LinkedHashSet<>();
  
}
