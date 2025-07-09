package com.etsia.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
@CrossOrigin("*")
public class Test {

    @GetMapping("")
    public String hello() {
        return ResponseEntity.ok("hello").getBody();
    }
}
