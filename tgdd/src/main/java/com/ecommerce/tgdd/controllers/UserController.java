package com.ecommerce.tgdd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("sign-up")
    public String signUp(Model model){
        return "client-side/user/sign-up";
    }
}
