package com.kamble.configuration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ConfigurationProperties("limits-service")  // SETTING DATA IN FIELDS FROM APP.PROPS FILE
@Component
public class LimitConfig {
    private int minimum;
    private int maximum;
}
