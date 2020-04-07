package com.hd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hd.dao")
@SpringBootApplication
public class VmdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmdsApplication.class, args);
	}

}
