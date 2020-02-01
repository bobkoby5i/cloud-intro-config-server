package com.koby5i.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ConfigClientApplication {

	@Value("${message:Hello default}")
	private static String message;


	public static void main(String[] args) {


		SpringApplication.run(ConfigClientApplication.class, args);
		System.out.println("Message: " + message );
	}

	@RefreshScope
	@RestController
	class MessageRestController {

		@Value("${message:Hello default}")
		private String message;

		@RequestMapping("/message")
		String getMessage() {
			System.out.println("Message: " + message );
			return this.message;
		}

	}

}


