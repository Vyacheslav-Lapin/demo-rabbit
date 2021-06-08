package ru.vlapin.demo.demorabbit.config;

import static ru.vlapin.demo.demorabbit.common.Loggable.LogLevel.DEBUG;
import static ru.vlapin.demo.demorabbit.common.Loggable.LogLevel.INFO;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.demorabbit.common.Loggable;
import ru.vlapin.demo.demorabbit.dao.CatRepository;
import ru.vlapin.demo.demorabbit.model.Cat;

@Loggable(INFO)
@Component
@RequiredArgsConstructor
public class DataJpaIniter implements ApplicationRunner {

  CatRepository catRepository;

  @Override
  public void run(ApplicationArguments __) {
    Stream.of("Мурзик, Барсик, Матроскин".split(", "))
        .map(Cat::new)
        .forEach(catRepository::save);
  }
}
