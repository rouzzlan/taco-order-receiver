package com.falcontech.orderreceiver.model.queue;

import java.util.UUID;

import lombok.Data;

@Data
public class Order {
  private final UUID uuid = UUID.randomUUID();
  private String name;
  private String email;
  private CCard cCard;
  private Address address;
}
