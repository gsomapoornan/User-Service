package com.visualpath.user.actuator.custom.endpoints;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customhealth")
public class CustomHealthEndPoint {

    @ReadOperation
    public CustomHealth health() {
        Map<String, Object> details = new LinkedHashMap<>();
        details.put("CustomHealthStatus", "Everything looks good");
        CustomHealth health = new CustomHealth();
        health.setHealthDetails(details);
        return health;
    }
   
}