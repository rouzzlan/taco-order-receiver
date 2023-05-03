package com.falcontech.orderreceiver.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="orders.services")
@Data
public class RemoteServiceProps {
    private String ccHost;
    private String addressHost;
}
