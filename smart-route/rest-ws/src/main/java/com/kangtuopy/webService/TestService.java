/**  
* <p>Title: TestService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface TestService {
	
    @WebMethod
    String sayHi(@WebParam(name = "name") String name);

}
