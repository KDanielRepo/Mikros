package com.pkisi.Feign;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MessageFeignFallback implements MessageFeignClient{
    public String feignGet() {
        //ResponseEntity responseEntity = new ResponseEntity("testowanie", HttpStatus.I_AM_A_TEAPOT);
        return "to jest moj fallback";
    }

    public void feignVoid() {
        ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT);
    }
}
