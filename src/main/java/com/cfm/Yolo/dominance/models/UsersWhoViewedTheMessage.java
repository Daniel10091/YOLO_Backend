package com.cfm.Yolo.dominance.models;

import java.time.Instant;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashSet;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsersWhoViewedTheMessage {
  
  private Integer id;
  private Message message;
  private Set<User> users = new LinkedHashSet<>();
  private Instant visualizedDate;

}
