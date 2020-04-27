package com.krupp.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GatewaySecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySecurityApplication.class, args);
    }

    @RestController
    public class IndexController {
        @GetMapping("/index")
        public String index() {
            return "Hello World ~";
        }
    }
}
