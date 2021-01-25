package com.meijia.rocketmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author kaiser
 */
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RocketmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RocketmqApplication.class, args);
	}

}
