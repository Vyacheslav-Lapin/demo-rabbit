package ru.vlapin.demo.demorabbit.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Comment {

  Long postId;

  Long id;

  String name;

  String email;

  String body;
}
