package com.falcontech.orderreceiver.queue;

import com.falcontech.orderreceiver.model.queue.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Connection;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Receiver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class OrderService {

  // Name of our Queue
  private static final String QUEUE = "orderqueue";

  // Connection to RabbitMQ
  @Autowired private Mono<Connection> connectionMono;

  final Receiver receiver;

  OrderService(Receiver receiver) {
    this.receiver = receiver;
  }

  // Listen to RabbitMQ as soon as this service is up
  @PostConstruct
  private void init() {
    consume();
  }

  // Make sure the connection before the program is finished
  @PreDestroy
  public void close() throws Exception {
    connectionMono.block().close();
  }

  // Consume messages from the queue
  public Disposable consume() {

    return receiver
        .consumeAutoAck(QUEUE)
        .subscribe(
            m -> {
              // 1. Deserialize byte to json
              String json = SerializationUtils.deserialize(m.getBody());
              ObjectMapper mapper = new ObjectMapper();
              Order order;
              // 2. map json to Order object
              try {
                order = mapper.readValue(json, Order.class);
                System.out.println(order.getName());
                /*
                    Business logic
                     ...
                */

              } catch (JsonProcessingException e) {
                e.printStackTrace();
              }
            });
  }
}
