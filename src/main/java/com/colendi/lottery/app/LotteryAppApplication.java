package com.colendi.lottery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.colendi.lottery.app.data.service"})
//@EntityScan("com.colendi.lottery.app.data.models")
//@EnableJpaRepositories("com.colendi.lottery.app.data.repository")
public class LotteryAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LotteryAppApplication.class, args);
	}

}
