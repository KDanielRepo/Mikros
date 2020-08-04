package com.pkisi.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feign",url = "localhost:8080",fallback = MessageFeignFallback.class,configuration = FeignConfiguration.class)
public interface MessageFeignClient {
    @GetMapping("/one")
    String feignGet();
    @GetMapping("/two")
    void feignVoid();
}
