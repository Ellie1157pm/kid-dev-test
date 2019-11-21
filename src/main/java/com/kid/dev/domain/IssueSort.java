package com.kid.dev.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 문제 2
 * 작업 목록 정렬
 */
public class IssueSort {
    /**
     * 작업 목록
     */
    private List<Issue> issueList;

    /**
     * 우선순위 이름
     */
    private Map<Integer, String> priorityName;

    /**
     * 1. 우선순위를 코드별로 이름을 설정해 맵에 담는다.(1: 긴급, 2: 보통, 3: 낮음)
     * 2. 작업 리스트 초기값을 설정한다.
     */
    public IssueSort() {
        // set priority names in the map variable
        priorityName = new HashMap<>();
        priorityName.put(1, "긴급");
        priorityName.put(2, "보통");
        priorityName.put(3, "낮음");

        // set values in Issue List
        issueList = new ArrayList<>();
        issueList.add(new Issue(3, 1, "A.로그인 화면 오타 수정"));
        issueList.add(new Issue(1, 3, "B.OTP 사용자 로그인 안됨"));
        issueList.add(new Issue(2, 1, "C.권한 안내 문구 수정"));
        issueList.add(new Issue(3, 2, "D.로딩중 표시 아이콘 변경"));
        issueList.add(new Issue(1, 3, "E.메일의 본문이 표시되지 않는 문제"));
        issueList.add(new Issue(2, 1, "F.첨부파일 사이즈 표시 오류 수정"));
        issueList.add(new Issue(1, 2, "G.메일 전송시 첨부파일 누락됨"));
        issueList.add(new Issue(2, 3, "H.1:1 문의 기능 구현"));
        issueList.add(new Issue(3, 1, "I.제품 로고 변경"));
        issueList.add(new Issue(2, 3, "J.안읽음 카운트 오류 문제"));
        issueList.add(new Issue(3, 1, "K.폰트 색상 변경"));
        issueList.add(new Issue(1, 2, "L.전체 메일함 동기화 안되는 문제"));
    }

    /**
     * 조건에 맞게 정렬된 작업 목록을 반환한다.
     * @return 정렬된 작업 목록
     */
    public List<Issue> sortIssueList() {
        List<Issue> sortedIssueList = issueList;
        Issue issue = null;

        for(int i = 0 ; i < issueList.size()-1 ; i++) {
            // 1. "긴급", "보통", "낮음" 의 우선 순위를 가진다.
            for(int j = i+1 ; j < issueList.size() ; j++) {
                if(sortedIssueList.get(i).getPriority() > sortedIssueList.get(j).getPriority()) {
                    issue = sortedIssueList.get(i);
                    sortedIssueList.set(i, sortedIssueList.get(j));
                    sortedIssueList.set(j, issue);
                }
            }

            // 2. 동일한 우선 순위 작업의 경우, 소요시간이 작은 것을 우선으로 한다.
            for(int j = i+1 ; j < sortedIssueList.size() ; j++) {
                if(sortedIssueList.get(i).getPriority() != sortedIssueList.get(j).getPriority()) continue;

                if(sortedIssueList.get(i).getDuration() > sortedIssueList.get(j).getDuration()) {
                    issue = sortedIssueList.get(i);
                    sortedIssueList.set(i, sortedIssueList.get(j));
                    sortedIssueList.set(j, issue);
                }
            }

            // 3.동일한 소요시간의 작업인 경우, 먼저 들어온 작업을 우선한다.
            for(int j = i+1 ; j < sortedIssueList.size() ; j++) {
                if(sortedIssueList.get(i).getPriority() != sortedIssueList.get(j).getPriority()) continue;
                if(sortedIssueList.get(i).getDuration() != sortedIssueList.get(j).getDuration()) continue;

                if(sortedIssueList.get(i).getIssue().compareTo(sortedIssueList.get(j).getIssue()) > 0) {
                    issue = sortedIssueList.get(i);
                    sortedIssueList.set(i, sortedIssueList.get(j));
                    sortedIssueList.set(j, issue);
                }
            }
        }

//        for(int i = 0 ; i < sortedIssueList.size()-1 ; i++) {
//            for(int j = i+1 ; j < sortedIssueList.size() ; j++) {
//                if(sortedIssueList.get(i).getPriority() != sortedIssueList.get(j).getPriority()) continue;
//
//                if(sortedIssueList.get(i).getDuration() > sortedIssueList.get(j).getDuration()) {
//                    issue = sortedIssueList.get(i);
//                    sortedIssueList.set(i, sortedIssueList.get(j));
//                    sortedIssueList.set(j, issue);
//                }
//            }
//        }
//
//        // 3.동일한 소요시간의 작업인 경우, 먼저 들어온 작업을 우선한다.
//        for(int i = 0 ; i < sortedIssueList.size()-1 ; i++) {
//            for(int j = i+1 ; j < sortedIssueList.size() ; j++) {
//                if(sortedIssueList.get(i).getPriority() != sortedIssueList.get(j).getPriority()) continue;
//                if(sortedIssueList.get(i).getDuration() != sortedIssueList.get(j).getDuration()) continue;
//
//                if(sortedIssueList.get(i).getIssue().compareTo(sortedIssueList.get(j).getIssue()) > 0) {
//                    issue = sortedIssueList.get(i);
//                    sortedIssueList.set(i, sortedIssueList.get(j));
//                    sortedIssueList.set(j, issue);
//                }
//            }
//        }

        return sortedIssueList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }

    public void setIssueList(List<Issue> issueList) {
        this.issueList = issueList;
    }

    public Map<Integer, String> getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(Map<Integer, String> priorityName) {
        this.priorityName = priorityName;
    }

    @Override
    public String toString() {
        return "IssueSort{" +
                "issueList=" + issueList +
                ", priorityName=" + priorityName +
                '}';
    }

}
