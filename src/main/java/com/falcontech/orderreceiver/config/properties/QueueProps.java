package com.falcontech.orderreceiver.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="orders.queue")
@Data
public class QueueProps {
    private String host;
    private String queueName;
    private int port;
    private String user;
    private String passwd;
}
