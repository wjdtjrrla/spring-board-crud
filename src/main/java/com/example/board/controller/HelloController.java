package com.example.board.controller; //해당 파일의 위치

//IntelliJ에서는 보통 빨간 글씨가 뜨면 Alt + Enter로 자동 import
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") //주소 연결
    public String hello() {
        return "hello spring";
    }

    @GetMapping("/study")
    public String study() {
        return "Spring Boot를 공부하고 있습니다.";
    }
}

