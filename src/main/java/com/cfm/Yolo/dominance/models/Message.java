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
public class Message {
  
  private Integer id;
  private User user;
  private byte[] content;
  private String messageText;
  private Set<UsersWhoViewedTheMessage> usersWhoViewedTheMessage = new LinkedHashSet<>();
  private Set<MessageLike> likes = new LinkedHashSet<>();
  private Instant createdDate;

}
