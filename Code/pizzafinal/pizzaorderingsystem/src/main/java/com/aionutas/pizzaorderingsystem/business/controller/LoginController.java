package com.aionutas.pizzaorderingsystem.controller;


import com.aionutas.pizzaorderingsystem.service.LoginService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginStatus(@RequestParam String username, @RequestParam String password) throws JSONException {
        return loginService.getUser(username,password);
    }


}
