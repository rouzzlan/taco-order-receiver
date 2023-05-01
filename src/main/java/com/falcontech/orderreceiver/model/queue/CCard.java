package com.falcontech.orderreceiver.model.queue;

import lombok.Data;

@Data
public class CCard {
  private String ccNumber;
  private String ccExpiration;
  private Integer cvv;
}
