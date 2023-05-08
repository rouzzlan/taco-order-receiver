package com.falcontech.orderreceiver.model.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document("TacoOrders")
public class Order {
    @Id
    private String id;
    private UUID uuid;
    private String name;
    private String email;
    private String cCardRef;
    private String AddrRef;
}
