package com.yatra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.yatra.service.YatraServceImpl;

@SpringBootApplication
public class YatraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(YatraApplication.class, args);
		YatraServceImpl bean = context.getBean(YatraServceImpl.class);
	}

}
