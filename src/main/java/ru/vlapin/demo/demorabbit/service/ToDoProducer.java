package ru.vlapin.demo.demorabbit.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.demorabbit.model.ToDo;

public interface ToDoProducer {
  void sendTo(String queue, ToDo toDo);
}

@Data
@Slf4j
@Component
@RequiredArgsConstructor
@ConfigurationProperties("todo.amqp")
class ToDoProducerImpl implements ToDoProducer {

  RabbitTemplate template;

  @NonFinal
  String queue = "demo";

  @NonFinal
  String message = "Lorem ipsum dolor sit amet";

  @Scheduled(
      fixedRate = 2 * 1_000,
      initialDelay = 2 * 1_000)
  public void sendTestMessage() {
    sendTo(queue, new ToDo(message));
  }

  @Override
  public void sendTo(String queue, ToDo toDo){
    template.convertAndSend(queue, toDo);
    log.info("Producer > Message Sent ({})", toDo);
  }
}
