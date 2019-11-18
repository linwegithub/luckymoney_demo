package com.imooc.luckmoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

//@Controller
@RestController
@RequestMapping("/fj")
public class HelloController {

////    @Value("${minMoney}")
////    private BigDecimal minMoney;
////    @Value("${description}")
//      private String description;
    @Autowired
    private  LimitConfig limitConfig;


    @GetMapping("/hello")
    @ResponseBody//返回String类型
    public  String say()
    {
        return "发红包功能"+limitConfig.getDescription();
    }

    @GetMapping("hello2")
    public  String say2()
    {
        //使用模板类型
        return "index";
    }
    @GetMapping("/hello2/{id}")
    @ResponseBody//返回String类型
    public  String say3(@PathVariable("id") Integer id )
    {
        //使用PathVariable获取URL中的数据
        return id.toString();
    }
    @GetMapping("/hello3")
    public  String say4(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id)
    {
        //使用RequestParam获取请求参数的值
        return id.toString();
    }
}
