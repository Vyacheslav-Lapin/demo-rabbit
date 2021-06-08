package ru.vlapin.demo.demorabbit.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import ru.vlapin.demo.demorabbit.model.ToDo;

@Slf4j
@Component
@RequiredArgsConstructor
public class ToDoProducer {

  RabbitTemplate template;

  public void sendTo(String queue, ToDo toDo){
    template.convertAndSend(queue, toDo);
    log.info("Producer> Message Sent");
  }
}
