package com.example.Ftp;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class FtpApplication {
	public static void main(String[] args) {
		SpringApplication.run(FtpApplication.class, args);
	}
}
