package com.aiwa.photon.app.account.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccManController {

    @GetMapping(path = "/check/status")
    public String accountStatus() {
        return "Account service running...";
    }

}
