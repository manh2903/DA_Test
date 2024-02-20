package com.example.da_test.controller;

import com.example.da_test.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class LoginController extends BaseController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(final Model model, final HttpServletRequest request,
                        final HttpServletResponse response) throws IOException {

        return "login";
    }


    @GetMapping(value = "/logout")
    public String logout() {
        return "home";
    }

}
