package com.koreait.spring_boot_study.controller;

import com.koreait.spring_boot_study.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller 에는 2가지 방식이 존재
//1. controller: html(웹페이지) 반환하는 서버 사이드 렌더링 (SSR)
//2. RestController: Json, 문자열 등 다양한 데이터를 반환 -> REST API 서버(웹서버)

//서버 사이드 렌더링은 서버측에서 프론트의 웹페이지까지 통째로 반환, 그걸 브라우저에서 띄움
//해당 요청 경로에 따라 웹페이지가 다 할당되어 있어서 느림

//하지만 우리가 하게 될 프론트 (리액트) + 백엔드 (스프링부트 웹서버)
//리액트는 클라이언트 사이드 렌더링 (CSR) 즉, 프론트엔드 쪽에서 웹페이지를 로드
//백엔드는 요청에 해당하는 데이터만 반환
//이러한 조합 -> Single Page Application (SPA) 방식

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    //Inversion Of Control -> 제어의 역전
    //객체 생성과 제어의 주도권을 개발자가 아닌, 스프링 부트가 갖는 것
    //ioc container -> 스프링부트가 만든 객체들을 담아두고 관리하는 창고
    //필요한 곳이 있으면 꺼내서 넣어줌
    //ioc container 에서 해당 객체를 찾아서 자동으로 넣어주기 때문에 우리는 new를 할 필요가 없음
    //이미 실행될 때 ioc container에 객체들이 생성되어 보관되어 있음

    //의존성 주입
    //Dependency Injection -> DI
    //필요한 객체(의존성)를 직접 만들지 않고, 외부(스프링부트)에서 대신 넣어주는 것

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public String getPost() {
        System.out.println("get으로 들어온 요청입니다~~");
        return postService.getPost();
    }

    @GetMapping("/user")
    public String getPostUser() {
        System.out.println("get/user로 들어온 요청입니다~~");
        return "어떤 게시물의 유저 정보";
    }
}
