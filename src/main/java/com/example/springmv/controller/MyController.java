package com.example.springmv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yangzxa on 2017/12/6.
 */
@Controller
public class MyController {

    //访问地址：http://localhost:8080/Test/returnSuccess
    @RequestMapping(value = "/hello")    //实际访问的url地址
    public String returnSuccess() {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    //访问地址：http://localhost:8080/Test/returnString
    @RequestMapping(value = "/returnString", produces = {"text/plain;charset=UTF-8"})
    //produces用于解决返回中文乱码问题，application/json;为json解决中文乱码
    @ResponseBody       //用于返回字符串,不写即返回视图
    public String returnString() {
        return "hello return string 这是中文，并没有乱码";
    }
}
