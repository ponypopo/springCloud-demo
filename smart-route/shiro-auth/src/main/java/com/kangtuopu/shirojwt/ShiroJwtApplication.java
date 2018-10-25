package com.kangtuopu.shirojwt;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
//@MapperScan(value = "com.kangtuopu.shirojwt.mapper")
public class ShiroJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroJwtApplication.class, args);
	}
}