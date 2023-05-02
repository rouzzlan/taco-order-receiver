package com.falcontech.orderreceiver;

import com.falcontech.orderreceiver.config.properties.QueueProps;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.RabbitFlux;
import reactor.rabbitmq.Receiver;
import reactor.rabbitmq.ReceiverOptions;

@Configuration
public class RabbitConfig {
  private final QueueProps queueProps;

  public RabbitConfig(QueueProps queueProps) {
    this.queueProps = queueProps;
  }

  @Bean()
  Mono<Connection> connectionMono() {
    ConnectionFactory connectionFactory = new ConnectionFactory();
    connectionFactory.setHost(queueProps.getHost());
    connectionFactory.setPort(queueProps.getPort());
    connectionFactory.setUsername(queueProps.getUser());
    connectionFactory.setPassword(queueProps.getPasswd());
    connectionFactory.useNio();
    return Mono.fromCallable(() -> connectionFactory.newConnection("tacocloud.order.queue"))
        .cache();
  }

  @Bean
  public ReceiverOptions receiverOptions(Mono<Connection> connectionMono) {
    return new ReceiverOptions().connectionMono(connectionMono);
  }

  @Bean
  Receiver receiver(ReceiverOptions receiverOptions) {
    return RabbitFlux.createReceiver(receiverOptions);
  }
}
