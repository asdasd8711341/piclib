package com.gsn.piclib.controller;

import com.gsn.piclib.future.PiclibFuture;
import com.gsn.piclib.service.PiclibRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private PiclibFuture piclibFuture;   // 异步方案

    @Autowired
    private PiclibRestService piclibRestService;  //同步方案

    @RequestMapping(value = "/list")
    public CompletableFuture<String> findAll() {
         return piclibFuture.findPage(1, 2, "test").thenApply(page -> page);
//        return piclibFuture.findPage(1, 2, "test").thenApply(new Function<String, String>() {
//            @Override
//            public String apply(String page) {
//                return page;
//            }
//        });
    }

    @RequestMapping(value = "/list1")
    public String findAll1() {
        return piclibRestService.findAll(1, 2, "test");
    }
}
