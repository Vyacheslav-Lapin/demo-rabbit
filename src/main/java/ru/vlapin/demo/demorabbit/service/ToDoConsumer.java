package ru.vlapin.demo.demorabbit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.demorabbit.dao.ToDoRepository;
import ru.vlapin.demo.demorabbit.model.ToDo;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoConsumer {

  ToDoRepository repository;

  @RabbitListener(queues = "${todo.amqp.queue:demo}")
  public void processToDo(ToDo todo) {
    log.info("Consumer> {}", todo);
    log.info("ToDo created> {}", repository.save(todo));
  }
}
