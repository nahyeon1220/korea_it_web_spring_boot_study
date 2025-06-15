package com.koreait.spring_boot_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SigninReqDto {
    private String email;
    private String password;

}
