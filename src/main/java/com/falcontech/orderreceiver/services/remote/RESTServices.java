package com.falcontech.orderreceiver.services.remote;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class RESTServices {
    private final WebClient ccWebClient;
    private final WebClient addressWebClient;


    public RESTServices(WebClient ccWebClient, WebClient addressWebClient) {
        this.ccWebClient = ccWebClient;
        this.addressWebClient = addressWebClient;
    }
}
