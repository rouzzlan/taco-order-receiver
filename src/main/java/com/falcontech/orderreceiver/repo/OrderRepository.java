package com.falcontech.orderreceiver.repo;

import com.falcontech.orderreceiver.model.mongo.Order;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, String> {}
