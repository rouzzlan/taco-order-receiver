package com.falcontech.orderreceiver.model.queue;

import lombok.Data;
@Data
public class Address {
  private String street;
  private String city;
  private String state;
  private String zip;
}