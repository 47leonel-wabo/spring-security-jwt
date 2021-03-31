package com.ada.springsecurityjwt.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/hello")
public class AppResource {

    @GetMapping
    public String sayHello() {
        return "Hello there!";
    }

}
