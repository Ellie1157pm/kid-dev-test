package com.kid.dev.controller;

import com.kid.dev.domain.IssueSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 작업 내역 정렬 페이지 맵핑 컨트롤러
 */
@Controller
public class IssueController {

    /**
     * 2번 문제 및 결과 출력 페이지 이동
     * @param model 작업 정렬 객체, 정렬된 작업 목록
     * @return 출력 페이지 맵핑 경로
     */
    @GetMapping("/issue/detail")
    public String issueDetail(Model model) {
        model.addAttribute("issueSort", new IssueSort());
        model.addAttribute("sortedIssueList", new IssueSort().sortIssueList());
        return "issue/detail";
    }

}
