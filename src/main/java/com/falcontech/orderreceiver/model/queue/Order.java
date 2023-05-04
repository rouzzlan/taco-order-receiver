package com.falcontech.orderreceiver.model.queue;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class Order {
  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String email;
  private CCard cCard;
  private Address address;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String cCardId;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String AddrId;
}
