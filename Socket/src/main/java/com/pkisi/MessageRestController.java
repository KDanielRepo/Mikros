package com.pkisi;

import com.pkisi.Feign.MessageFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

    @Autowired
    private MessageFeignClient feignClient;

    @GetMapping("/test")
    private String getTest() {
        return feignClient.feignGet();
    }
    @GetMapping("testtwo")
    private void getVoid(){
        feignClient.feignVoid();
    }
}
