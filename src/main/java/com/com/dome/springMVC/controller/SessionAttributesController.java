package com.example.springmv.controller;

import com.tiku.spring.bean.ExcmpleVO;
import com.tiku.spring.bean.MultChoiceVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @SessionAttributes注解只能在类上使用，不能在方法上使用.
 * RequestMapping查询的方法执行后
 * 会遍历ModelAndView中的Map中将键（value）、值类型（types）相符合的key-value 放入到session中
 */
@SessionAttributes(value={“user1”, “user2”}, types={MultChoiceVO.class}) 
@Controller
@RequestMapping(value = "/dome/SessionAttributes")
public class SessionAttributesController {

    /**
     * @ModelAttribute 用在方法上，在每一个RequestMapping调用前调用，并将该方法的返回值放入model中，键值如果没有指定就是类名小写
     */
    @ModelAttribute(value = "modelAttribute" )    //实际访问的url地址
    public MultChoiceVO modelAttribute() {
        return new MultChoiceVO();    //返回Views文件夹下的success.jsp页面
    }

    /**
     *  @ModelAttribute 用在参数中，框架处理完参数后将标注的参数放入model中然后进行调用方法
     * @param  optionItemVO [description]
     * @return              [description]
     */
    @RequestMapping(value = "/hello" )  
    public String returnSuccess1( @ModelAttribute OptionItemVO optionItemVO ) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @PathVariable  映射 URL 绑定的占位符 映射可以转换为什么
    @RequestMapping(value = "/PathVariable/{id}" )   
    public String pathVariable(@PathVariable("id") String id) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

     // @RequestParam  绑定请求参数值
    @RequestMapping(value = "/RequestParam " )   
    public String requestParam(@RequestParam ( value ="id" ,required = false) String id) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @RequestHeader   绑定请求参数值
    @RequestMapping(value = "/RequestHeader  " )   
    public String requestHeader(@RequestHeader  ( "Accept-Encoding") String encoding) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

    // @CookieValue 绑定请求中的 Cookie 值
    @RequestMapping(value = "/CookieValue   " )   
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
    @RequestMapping(value = "/ServletAPI   " )   
    public String servletAPI(HttpSession session) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }

   
   @SessionAttributes
   @RequestMapping(value = "/ServletAPI   " ) 
   public String sessionAttributes(HttpSession session) {
        return "success";    //返回Views文件夹下的success.jsp页面
    }


}
