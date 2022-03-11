package ru.vlapin.demo.demorabbit.model.jsonplaceholder;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder(toBuilder = true)
public class Photo {

  Long albumId;
  Long id;
  String title;
  String url;
  String thumbnailUrl;
}
