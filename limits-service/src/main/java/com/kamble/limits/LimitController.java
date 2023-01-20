package com.kamble.limits;

import com.kamble.configuration.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("limits")
    public Limit getAllLimits() {
        return Limit.builder().min(limitConfig.getMinimum()).max(limitConfig.getMaximum()).build();
    }
}
