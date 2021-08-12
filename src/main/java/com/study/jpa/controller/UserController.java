package com.study.jpa.controller;

import com.study.jpa.entity.User;
import com.study.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    /*@Autowired
    UserRepository userRepository;*/
    private final UserService userService;

    @GetMapping("/select.do")
    @ResponseBody
    public Map<String, Object> selectAllUser() {
        Map<String, Object> response = new HashMap<>();

        List<User> userList = userService.selectAll();
        response.put("result", userList);

        return response;
    }
}
