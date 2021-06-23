package ru.vlapin.demo.demorabbit;

import static org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType.HAL;

import lombok.val;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import ru.vlapin.demo.demorabbit.model.ToDo;
import ru.vlapin.demo.demorabbit.service.ToDoProducer;

@EnableFeignClients
@SpringBootApplication
@ConfigurationPropertiesScan
@EnableHypermediaSupport(type = HAL)
@ComponentScan(includeFilters = @Filter(Aspect.class))
public class DemoRabbitApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoRabbitApplication.class, args);
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
    val factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setMessageConverter(new Jackson2JsonMessageConverter());
    return factory;
  }

  @Bean
  public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
    val template = new RabbitTemplate(connectionFactory);
    template.setMessageConverter(new Jackson2JsonMessageConverter());
    return template;
  }

  @Bean
  public Queue queueCreation(@Value("${todo.amqp.queue}") String queue) {
    return new Queue(queue, true, false, false);
  }

  @Bean
  public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String destination,
                                     ToDoProducer producer) {
    return __ -> producer.sendTo(destination, new ToDo("workout tomorrow morning!"));
  }
}
