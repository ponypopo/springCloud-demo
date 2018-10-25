/**  
* <p>Title: WsClient.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy.webService.impl;

import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling 
public class WsClient {
	  
	  public static void main(String[] args) throws Exception{
		  try{
			  JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
			  org.apache.cxf.endpoint.Client c =dcf.createClient("http://localhost:8086/ws?wsdl");
			  Object[] objects=c.invoke("sayHi","wawa哇");
	          System.out.println("result="  + objects[0].toString());
	      }catch(Exception e){
			  e.printStackTrace();
		  }
	  }
}
