package com.ahmedzahran.CloudGatewayTwo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallback(){
        return "Order Service is Down";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallback(){
        return "Payment Service is Down";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallback(){
        return "Order Service is Down";
    }
}
