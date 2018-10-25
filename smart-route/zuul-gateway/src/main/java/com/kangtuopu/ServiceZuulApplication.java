/**  
* <p>Title: ServiceZuulApplication.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月18日  
* @version 1.0  
*/
package com.kangtuopu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.kangtuopu.filter.AccessTokenFilter;

/**  
 * <p>Title: ServiceZuulApplication</p>  
 * <p>Description: </p>  
 * @author zhengyuanping
 * @date 2018年10月18日  
 */
@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
//@EnableDiscoveryClient
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run( ServiceZuulApplication.class, args );
    }
    
    /**
     * 加载过滤器
     * @return
     */
    @Bean
    public AccessTokenFilter accessFilter() {
        return new AccessTokenFilter();
    }
}
