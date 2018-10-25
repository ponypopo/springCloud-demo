/**  
* <p>Title: ZuulFilter.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2017</p>  
* <p>Company: www.csg.com</p>  
* @author zhengyuanping
* @date 2018年10月18日  
* @version 1.0  
*/
package com.kangtuopu.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**  
 * <p>Title: ZuulFilter</p>  
 * <p>Description: </p>  
 * @author zhengyuanping
 * @date 2018年10月18日  
 */
@Component
public class AccessTokenFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessTokenFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        //Object accessToken = request.getParameter("token");
        Object accessToken = request.getHeader("token");
//        if(accessToken == null) {
//            log.warn("token is empty");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            try {
//                ctx.getResponse().getWriter().write("token is empty");
//            }catch (Exception e){}
//
//            return null;
//        }
        log.info("ok");
        return null;
    }
}
