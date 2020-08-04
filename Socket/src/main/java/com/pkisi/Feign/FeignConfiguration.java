package com.pkisi.Feign;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Configuration
public class FeignConfiguration {
    @Bean
    public ResponseEntity encoder(){
        return new ResponseEntity(HttpStatus.I_AM_A_TEAPOT);
    }
}
