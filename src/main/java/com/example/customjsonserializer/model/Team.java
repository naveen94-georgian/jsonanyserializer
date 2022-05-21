package com.example.customjsonserializer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Team extends AnyPropHelper {

  private Long id;

  private String teamName;

  private List<User> userList;
}
