/**  
* <p>Title: TestController.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月24日  
* @version 1.0  
*/
package com.kangtuopy.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/")
public class TestController {
	
	 @RequestMapping(value="/test",method=RequestMethod.GET)
	 Map<String,Object> list() {
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("func", "test");
		 map.put("name", "king");
		 return map;
	 }

}
