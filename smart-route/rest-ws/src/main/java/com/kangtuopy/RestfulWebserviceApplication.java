/**  
* <p>Title: Application.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RestfulWebserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebserviceApplication.class, args);
		System.out.println("*****************************");
		System.out.println("*******双协议服务启动成功**********");
		System.out.println("*****************************");
	}
	
}
