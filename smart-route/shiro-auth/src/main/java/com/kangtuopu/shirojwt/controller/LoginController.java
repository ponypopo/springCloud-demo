package com.kangtuopu.shirojwt.controller;

import com.kangtuopu.shirojwt.model.ResultMap;
import com.kangtuopu.shirojwt.util.JWTUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description
 * @Date 2018-04-29
 * @Time 13:20
 */
@RestController
public class LoginController {
    private final ResultMap resultMap;

    @Autowired
    public LoginController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @PostMapping("/login")
    public ResultMap login(@RequestParam("username") String username,
                           @RequestParam("password") String password) {
        String realPassword = null;
        if(null == username || "".equals(username.trim())){
        	return resultMap.fail().code(401).message("用户名为空");
        }else if("zyp".equals(username)){
        	realPassword = "123456";
        }else if("lrp".equals(username)){
        	realPassword = "123456";
        }else if("pony".equals(username)){
        	realPassword = "123456";
        }
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            return resultMap.success().code(200).message(JWTUtil.createToken(username));
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }
}
