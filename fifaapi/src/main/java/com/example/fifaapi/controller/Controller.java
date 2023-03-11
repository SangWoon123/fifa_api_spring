package com.example.fifaapi.controller;

import com.example.fifaapi.dto.UserDto;
import com.example.fifaapi.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fifa")
public class Controller {

    private UserInfo userInfo;
    @Autowired
    public Controller(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @GetMapping("/{nickname}")
    public String getUserInfo(@PathVariable String nickname){
        UserDto info = userInfo.getUsetInfo(nickname);
        System.out.println(info.getLevel());
        System.out.println(info.getNickname());
        System.out.println(info.getAccessId());
        return "너의 레벨: "+info.getLevel();
    }


}
