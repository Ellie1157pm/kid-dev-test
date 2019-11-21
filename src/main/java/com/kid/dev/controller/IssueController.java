package com.kid.dev.controller;

import com.kid.dev.domain.IssueSort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IssueController {

    @GetMapping("/issue/detail")
    public String issueDetail(Model model) {
        model.addAttribute("issueSort", new IssueSort());
        model.addAttribute("sortedIssueList", new IssueSort().sortIssueList());
        return "issue/detail";
    }

}
