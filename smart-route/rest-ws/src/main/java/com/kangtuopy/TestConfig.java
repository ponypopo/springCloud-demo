/**  
* <p>Title: TestConfig.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.kangtuopy.webService.TestService;
import com.kangtuopy.webService.impl.TestServiceImpl;

/**
 * @author wh
 * @date 2018年5月24日 上午11:52:42 
*  @Description: servlet配置
 */
@Configuration
public class TestConfig {
   
     @Bean
     public ServletRegistrationBean dispatcherServlet() {
         return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
     }
     
     /**
      * 添加普通的controller处理
     * @return
     */
     @Bean
     public ServletRegistrationBean dispatcherRestServlet() {
         AnnotationConfigWebApplicationContext context
                 = new AnnotationConfigWebApplicationContext();
         //替换成自己想买的controller包路径
         context.scan("com.kangtuopy.controller");
         DispatcherServlet disp = new DispatcherServlet(context);
         ServletRegistrationBean registrationBean = new ServletRegistrationBean(disp);
         registrationBean.setLoadOnStartup(1);
         //映射路径自定义,必须设置一个不重复的名称
         registrationBean.addUrlMappings("/rest/*");
         registrationBean.setName("rest");
         return registrationBean;
     }
     
      @Bean(name = Bus.DEFAULT_BUS_ID)
      public SpringBus springBus() {
          return new SpringBus();
      }
      
      @Bean
      public TestService testService() {
          return new TestServiceImpl();
      }
      
      @Bean
      public Endpoint endpoint() {
          EndpointImpl endpoint = new EndpointImpl(springBus(), testService());
          endpoint.publish("/");
          return endpoint;
      }
}
