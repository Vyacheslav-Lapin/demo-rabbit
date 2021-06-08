package ru.vlapin.demo.demorabbit.model.jsonplaceholder;

import static lombok.AccessLevel.PRIVATE;

import lombok.Data;
import lombok.Setter;

@Data
@Setter(PRIVATE)
public class Post {

  Long userId;
  Long id;
  String title;
  String body;
}
