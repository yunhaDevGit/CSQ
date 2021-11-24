package io.ezstudy.open.csq.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final HttpSession httpSession;

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
