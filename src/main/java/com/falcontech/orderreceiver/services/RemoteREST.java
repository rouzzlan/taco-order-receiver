package com.falcontech.orderreceiver.services;

import com.falcontech.orderreceiver.config.properties.RemoteServiceProps;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RemoteREST {
  private final RemoteServiceProps remoteServiceProps;

  public RemoteREST(RemoteServiceProps remoteServiceProps) {
    this.remoteServiceProps = remoteServiceProps;
  }

  @Bean
  public WebClient ccWebClient() {
    System.out.println(remoteServiceProps.getCcHost());
    return WebClient.create(remoteServiceProps.getCcHost());
  }

  @Bean
  public WebClient addressWebClient() {
    System.out.println(remoteServiceProps.getAddressHost());
    return WebClient.create(remoteServiceProps.getAddressHost());
  }
}
