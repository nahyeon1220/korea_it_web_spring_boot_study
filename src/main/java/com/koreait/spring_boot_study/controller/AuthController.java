package com.koreait.spring_boot_study.controller;

import com.koreait.spring_boot_study.dto.SignupReqDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    //@RequestParam
    //클라이언트가 URL 쿼리스트링으로 넘긴 값을 메소드 파라미터로 전달

    @GetMapping("/get")
    public String getUSer(@RequestParam String userId) {
        System.out.println("RequestParam으로 들어온 값: " + userId);
        return "RequestParam으로 들어온 값: " + userId;
    }

    @GetMapping("/get/name")
    public String getUsername(@RequestParam(value="name", defaultValue = "홍길동") String username, @RequestParam(required = false) Integer age) {
        System.out.println(username + age);
        return username + age;
    }
    //안에서 사용하는 변수명과 쿼리스트링의 키값이 다른 경우, 괄호 안에 표기해주면 됨
    //defaultValue를 통해 기본값 설정도 가능
    //다른 타입도 가능하며, 여러 개의 RequestParam도 받을 수 있음
    //Integer은 아무 값도 입력하지 않으면 null이지만, int는 null을 허용하지 않기 때문에 값이 없음의 상태
    //required는 기본적으로 true 값
    //그래서 required = false를 했지만 에러가 뜨고, Integer로 해야 null로 받을 수 있음
    //만약, 필수값이 false이고 기본값이 설정되어 있다면 필수값 설정이 무의미

    @GetMapping("/get/names")
    public String getUsernames(@RequestParam List<String> names){
        return names.toString();
    }

    //RequestParam 주의사항
    //1. 파라미터가 없으면 500에러
    //2. 타입 불일치
    //3. 이름 불일치
    //4. 민감한 정보 금지

    //요청 주소 /search -> name, email
    //name은 필수 x, email은 기본값으로 no-email
    //요청 -> /auth.search?name=lee
    //반환 -> "검색 조건 - 이름: ***, 이메일: ***"

    @GetMapping("/search")
    public String searchUser(@RequestParam(required = false) String name, @RequestParam(defaultValue = "no-email") String email) {
        return "검색 조건 - 이름: " + name + ", 이메일: " + email;
    }

    //@RequestBody
    //HTTP 요청의 바디에 들어있는 JSON 데이터를 자바 객체(DTO)로 변환하여 주입해주는 어노테이션
    //백엔드 서버는 그 JSON을 @RequestBody가 붙은 DTO로 자동 매핑
    //일반적으로 POST, PUT, PATCH에서 사용

    //DTO(Data Transfer Object)
    //데이터를 전달하기 위한 객체
    //클라이언트간에 데이터를 주고 받을 때 사용하는 중간 객체

    @PostMapping("/signup")
    public String signup(@RequestBody SignupReqDto signupReqDto){
        System.out.println(signupReqDto);
        return signupReqDto.getUsername() + "님 회원가입이 완료되었습니다.";
    }

    //Post요청 signin 로그인 로직
    //SigninReqDto => email, password
    //반환 "로그인 완료 : " + signinReqDto.getEmail() + "님 반갑습니다."
    @PostMapping("/signin")
    public String signin(@RequestBody SignupReqDto signinReqDto) {
        return "로그인 완료 : " + signinReqDto.getEmail() + "님 반갑습니다.";
    }

}
