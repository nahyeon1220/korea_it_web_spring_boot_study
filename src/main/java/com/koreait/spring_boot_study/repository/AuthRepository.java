package com.koreait.spring_boot_study.repository;

import com.koreait.spring_boot_study.dto.SignupReqDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthRepository {
    private final Map<String, String> userDb = new HashMap<>();

    public AuthRepository() {
        userDb.put("test@example.com", "홍길동");
    }

    public int finalByEmail(String email){
        if(userDb.containsKey(email)){
            return 0;
        } else {
            return 1;
        }
    }

    public int addUser(SignupReqDto signupReqDto){
        userDb.put(signupReqDto.getEmail(), signupReqDto.getUsername());
        return 1;
    }
}
