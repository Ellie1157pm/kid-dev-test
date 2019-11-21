package com.kid.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 작업 내역 정렬 페이지 맵핑 컨트롤러
 */
@Controller
public class ArrayController {

    /**
     * 1번 문제 및 결과 출력 페이지 이동
     * @param model 2차원 배열 정렬 객체
     * @return 출력 페이지 맵핑 경로
     */
    @GetMapping("/array/detail")
    public String arrayDetail(Model model) {
        return "array/detail";
    }

}
