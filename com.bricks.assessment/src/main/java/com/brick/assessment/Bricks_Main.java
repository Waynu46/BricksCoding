package com.brick.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan({"com.brick"})
public class Bricks_Main {
	public static void main(String[] args) {
		SpringApplication.run(Bricks_Main.class, args);
	}
}
