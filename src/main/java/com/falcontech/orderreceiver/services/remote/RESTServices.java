package com.falcontech.orderreceiver.services.remote;

import com.falcontech.orderreceiver.model.queue.Address;
import com.falcontech.orderreceiver.model.queue.CCard;
import com.falcontech.orderreceiver.model.queue.Order;
import com.falcontech.orderreceiver.model.web.ObjectResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class RESTServices {
  private final WebClient ccWebClient;
  private final WebClient addressWebClient;

  public RESTServices(WebClient ccWebClient, WebClient addressWebClient) {
    this.ccWebClient = ccWebClient;
    this.addressWebClient = addressWebClient;
  }

  public Mono<Order> getCCInfo(Order order) {
    return ccWebClient
        .post()
        .body(Mono.just(order.getCCard()), CCard.class)
        .retrieve()
        .bodyToMono(ObjectResponse.class)
        .map(
            objectResponse -> {
              order.setCCardId(objectResponse.hash());
              return order;
            });
  }

  public Mono<Order> getAddr(Order order) {
    return addressWebClient
        .post()
        .body(Mono.just(order.getAddress()), Address.class)
        .retrieve()
        .bodyToMono(ObjectResponse.class)
        .map(
            objectResponse -> {
              order.setAddrId(objectResponse.hash());
              return order;
            });
  }
}
