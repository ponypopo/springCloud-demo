package com.kangtuopu.shirojwt.controller;

import com.kangtuopu.shirojwt.model.ResultMap;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 *
 * @Author yuanhaoyue swithaoy@gmail.com
 * @Description admin角色权限controller
 * @Date 2018-04-29
 * @Time 17:32
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ResultMap resultMap;

    @Autowired
    public AdminController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public ResultMap getUser() {
        List<String> list = new ArrayList<String>();
        list.add("zyp");
        list.add("lrp");
        list.add("pony");
        return resultMap.success().code(200).message(list);
    }

    
}
