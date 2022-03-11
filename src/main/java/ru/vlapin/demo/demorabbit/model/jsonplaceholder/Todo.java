package ru.vlapin.demo.demorabbit.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Todo {

  Long userId;
  Long id;
  String title;
  Boolean completed;
}
