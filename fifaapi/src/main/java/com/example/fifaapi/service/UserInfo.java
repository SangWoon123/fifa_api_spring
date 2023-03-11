package com.example.fifaapi.service;

import com.example.fifaapi.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInfo {
    RestTemplate restTemplate=new RestTemplate();
    private String apiUrl="https://api.nexon.co.kr/fifaonline4/v1.0/users?nickname={nickname}";

    @Value("{systemEnvironment['FIFA_API_KEY']}")
    private String apiKey;

    @Autowired
    public UserInfo(){
        this.restTemplate=new RestTemplate();
    }

    public UserDto getUsetInfo(String username){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization",apiKey);
        HttpEntity<?> entity=new HttpEntity<>(headers);

        ResponseEntity<UserDto> response=restTemplate.exchange(apiUrl, HttpMethod.GET
        ,entity, UserDto.class,username);

        return response.getBody();

    }



}
