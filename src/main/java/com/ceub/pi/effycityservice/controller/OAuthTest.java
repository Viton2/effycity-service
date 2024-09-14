package com.ceub.pi.effycityservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

@RestController
@RequestMapping
public class OAuthTest {

//    @GetMapping("/")
//    public String test(){
//        return "Hello World!";
//    }

    @GetMapping("/secured")
    public String secured(){
        return "Hello, secured!";
    }
}
