package com.app.boss;


import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BossAppMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BossAppMqApplication.class, args);
	}
	
	@Bean
	public Queue queue() {
        return new Queue("chat");
    }


}
