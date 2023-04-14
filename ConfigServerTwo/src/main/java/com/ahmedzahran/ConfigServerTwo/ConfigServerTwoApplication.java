package com.ahmedzahran.ConfigServerTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerTwoApplication.class, args);
	}

}
