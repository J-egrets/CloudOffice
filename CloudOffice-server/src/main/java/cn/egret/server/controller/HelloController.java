package cn.egret.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author egret
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    /**
     * 测试基本资料
     * @return
     */
    @GetMapping("/employee/base/hello")
    public String hello2(){
        return "/employee/base/hello";
    }

    /**
     * 测试高级资料
     * @return
     */
    @GetMapping("/employee/advanced/hello")
    public String hello3(){
        return "/employee/advanced/hello";
    }
}
