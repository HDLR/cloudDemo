package io.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("io.com.dao")
public class ComGerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComGerApplication.class, args);
	}
}
