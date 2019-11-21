package com.kid.dev.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제 2
 * 작업
 */
public class Issue {

    /**
     * 우선순위 코드
     */
    private int priority;

    /**
     * 소요시간
     */
    private int duration;

    /**
     * 작업내용
     */
    private String issue;

    public Issue() {}

    public Issue(int priority, int duration, String issue) {
        this.priority = priority;
        this.duration = duration;
        this.issue = issue;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    @Override
    public String toString() {
        return priority + ", " + duration + ", " + issue;
    }
}
