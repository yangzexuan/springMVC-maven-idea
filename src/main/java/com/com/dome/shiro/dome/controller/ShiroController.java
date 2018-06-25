package com.com.dome.shiro.dome.controller;

import com.com.dome.shiro.dome.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by yangzxa on 2017/12/6.
 */
@Controller
@RequestMapping(value = "/shiro")
public class ShiroController {

    @Autowired
    private ShiroService service;

    @RequestMapping(value = "/hello" )    //实际访问的url地址
    public String returnSuccess() {
        this.service.adminService();
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }
    @RequestMapping(value = "/shirologin" )
    public String shiroLogin(String username,String password){

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                currentUser.login(token);
                System.out.println("登陆成功!");
            } catch (AuthenticationException ae) {
                System.out.println("登陆失败!");
            }
        }

        return "redirect:/shiro/success";

    }

//请求必须包含名为 param1 和param2 的两个请求参数，且 param1 参数的值必须为 value1
    @RequestMapping(value = "/hello1" ,params = {"param1=value1", "param2"} ,method = RequestMethod.POST
           )
    public String returnSuccess1() {
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }

    // @PathVariable  映射 URL 绑定的占位符 映射可以转换为什么
    @RequestMapping(value = "/PathVariable/{id}" )   
    public String pathVariable(@PathVariable("id") String id) {
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }

     // @RequestParam  绑定请求参数值
    @RequestMapping(value = "/RequestParam" )
    public String requestParam(@RequestParam( value ="id" ,required = false) String id) {
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }

    // @RequestHeader   绑定请求参数值
    @RequestMapping(value = "/RequestHeader" )
    public String requestHeader(@RequestHeader  ( "Accept-Encoding") String encoding) {
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }

    // @CookieValue 绑定请求中的 Cookie 值
    @RequestMapping(value = "/CookieValue" )
    public String cookieValue(@CookieValue   ( value ="sessionid" ,required = false) String sessionid) {
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
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
        return "shiro/success";    //返回Views文件夹下的success.jsp页面
    }

    @RequestMapping(value = "/role/user" )
    public String pathUser(){
        return "shiro/role/user";


    }

    @RequestMapping(value = "/role/admin" )
    public String pathAdmin(){
        return "shiro/role/admin";


    }
    @RequestMapping(value = "/success" )
    public String success(){
        return "shiro/success";


    }

//    springMVC 的异常处理
    @ExceptionHandler({AuthorizationException.class})
    public String handleAuthorizationException(Exception exception){
        System.out.println(exception.getClass().getName());
        return "redirect:/shiro/unauthorized.jsp";
    }

}
