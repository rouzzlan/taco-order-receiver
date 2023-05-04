package com.falcontech.orderreceiver.config;

import com.falcontech.orderreceiver.config.properties.RemoteServiceProps;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RemoteRESTConfig {
  private final RemoteServiceProps remoteServiceProps;

  public RemoteRESTConfig(RemoteServiceProps remoteServiceProps) {
    this.remoteServiceProps = remoteServiceProps;
  }

  @Bean
  public WebClient ccWebClient() {
    return WebClient.create(remoteServiceProps.getCcHost());
  }

  @Bean
  public WebClient addressWebClient() {
    return WebClient.create(remoteServiceProps.getAddressHost());
  }
}
