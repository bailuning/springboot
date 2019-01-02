package com.bailuning.operation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bailuning.operation.code.config.MyHttpSessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

//    private final Logger logger = LoggerFactory.getLogger(UserController.class);
//
//    @Value("${application.message:Hello World}")
//    private String message ;
//
//    @GetMapping("/asd/{name}")
//    public String welcome(@PathVariable String name) {
//        return this.message;
//    }
//
//    @RequestMapping("/login")
//    @ResponseBody
//    public Object foo() {
//        logger.info("打印日志----------------------");
//        return  "login";
//    }
//
//    @RequestMapping("/index")
//    @ResponseBody
//    public Object index(HttpServletRequest request) {
//        HttpSession  session = request.getSession(true);
//        session.setAttribute("zxc", "zxc");
//        return  "index";
//    }
//
//    @RequestMapping("/online")
//    @ResponseBody
//    public Object online() {
//        int po = MyHttpSessionListener.online;
//        return  "当前在线人数：" + po+ "人";
//    }
}