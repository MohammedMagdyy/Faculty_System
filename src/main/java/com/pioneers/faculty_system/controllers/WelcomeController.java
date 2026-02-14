package com.pioneers.faculty_system.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {

    @GetMapping("/{name}")
    public String welcome1(@PathVariable(value = "name") String studentName) {
        return "<h1 style=\"color:red\">Welcome Ya.... </h1>" + studentName;
    }

    @GetMapping("/name")
    public String welcome2(@RequestParam String name) {
        return "<h1 style=\"color:red\">Welcome Ya.... </h1>" + name;
    }
}
