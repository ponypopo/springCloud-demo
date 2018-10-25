/**  
* <p>Title: TestServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy.webService.impl;

import javax.jws.WebService;

import com.kangtuopy.webService.TestService;

@WebService(targetNamespace="http://wss.restWs.tiger.com/",
endpointInterface = "com.kangtuopy.webService.TestService")
public class TestServiceImpl implements TestService{

	public String sayHi(String name) {
		return "hello," + name;
	}

}
