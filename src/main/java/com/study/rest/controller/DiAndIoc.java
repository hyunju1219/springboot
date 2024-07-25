package com.study.rest.controller;

import com.study.rest.di.C;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DiAndIoc {

    @Autowired
    private C c;

    @Autowired
    @Qualifier("ts")
    private TestService testService1;

//    @Autowired
//    private TestServiceImpl testService11;

    @Autowired
    @Qualifier("newTestServiceImpl")
    private TestService testService2;


    @ResponseBody
    @GetMapping("/di")
    public Object di() {
        //A가 B를 의존하는 관계
//        a = new AClass();

        return null;
    }

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }

    @ResponseBody
    @GetMapping("/test")
    public Object startedTest(@RequestParam String type) {
        if("old".equals(type)) {
            testService1.test();
        } else {
            testService2.test();
        }
        return "/views/test";
    }
}
