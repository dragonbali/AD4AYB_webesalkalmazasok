package com.meiit.webalk.ad4ayb;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ReservationAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationAppApplication.class, args);
	}

}
