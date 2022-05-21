package com.example.customjsonserializer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User extends AnyPropHelper {

  private String userObjectID;

  private Team team;

  private boolean consent;

  private OffsetDateTime createdOn;

  private OffsetDateTime lastActive;
}
