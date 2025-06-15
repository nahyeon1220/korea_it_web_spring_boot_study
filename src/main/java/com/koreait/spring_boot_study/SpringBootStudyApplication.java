package com.koreait.spring_boot_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}

}
//MVC
//M (Model): 데이터 및 비즈니스 로직 처리 -> Entity, Service, Repository
//V (View): 사용자에게 보여지는 화면 -> html, Json, 응답 등등
//C (Controller): 요청을 받아서 모델에 전달하고, 처리결과를 뷰로 반환 -> RestController, Controller

