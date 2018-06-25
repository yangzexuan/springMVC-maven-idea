package com.com.dome.springMVC.controller;

import com.tiku.spring.bean.ExcmpleVO;
import com.tiku.spring.bean.MultChoiceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by yangzxa on 2017/12/6.
 */
@Controller
@RequestMapping(value = "/dome")
public class DomeController {

    @RequestMapping(value = "/hello" )    //实际访问的url地址
    public String returnSuccess() {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

//请求必须包含名为 param1 和param2 的两个请求参数，且 param1 参数的值必须为 value1
    @RequestMapping(value = "/hello" ,params = {"param1=value1", "param2"} ,method = RequestMethod.POST)
    public String returnSuccess1() {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @PathVariable  映射 URL 绑定的占位符 映射可以转换为什么
    @RequestMapping(value = "/PathVariable/{id}" )   
    public String pathVariable(@PathVariable("id") String id) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

     // @RequestParam  绑定请求参数值
    @RequestMapping(value = "/RequestParam" )
    public String requestParam(@RequestParam( value ="id" ,required = false) String id) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @RequestHeader   绑定请求参数值
    @RequestMapping(value = "/RequestHeader" )
    public String requestHeader(@RequestHeader  ( "Accept-Encoding") String encoding) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @CookieValue 绑定请求中的 Cookie 值
    @RequestMapping(value = "/CookieValue" )
    public String cookieValue(@CookieValue   ( value ="sessionid" ,required = false) String sessionid) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

     /*
        Handler 方法可以接受哪些 ServletAPI 类型的参数
        HttpServletRequest
        HttpServletResponse
        HttpSession
        java.security.Principal
        Locale
        InputStream
        OutputStream
        Reader
        Writer
      */
    @RequestMapping(value = "/ServletAPI" )
    public String servletAPI(HttpSession session) {

        return "success";    //返回Views文件夹下的success.jsp页面
    }

    }

   

