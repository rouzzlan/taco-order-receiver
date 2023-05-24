package com.falcontech.orderreceiver.model.queue;

import lombok.Data;

@Data
public class CCard {
  private String number;
  private String expiration;
  private Integer cvv;
  private String owner;
}
