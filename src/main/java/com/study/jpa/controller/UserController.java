package com.study.jpa.controller;

import com.study.jpa.entity.User;
import com.study.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("/select.do")
    @ResponseBody
    public Map<String, Object> selectAllUser() {
        Map<String, Object> response = new HashMap<>();

        List<User> userList = userService.selectAll();
        response.put("result", userList);

        return response;
    }

    @GetMapping("/selectUser.do")
    public ResponseEntity<Map<String, Object>> selectAllUserEntity() {
        // setting response Header
        MultiValueMap<String , String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/*+json");

        // return data
        Map<String, Object> response = new HashMap<>();
        List<User> userList = userService.selectAll();
        response.put("result", userList);

        return new ResponseEntity<>(response, headers, HttpStatus.OK);
    }
}
