package com.schoolsystem.pojo;

import java.sql.Timestamp;

public class AdminApproval {
    private int id;
    private int applyId;
    private String handler;
    private Timestamp processDate;
    private int processResult;
    private String processComment;


    public AdminApproval() {
    }

    public AdminApproval(int applyId, String handler, int processResult, String processComment) {
        this.applyId = applyId;
        this.handler = handler;
        this.processResult = processResult;
        this.processComment = processComment;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplyId() {
        return applyId;
    }

    public void setApplyId(int applyId) {
        this.applyId = applyId;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Timestamp getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Timestamp processDate) {
        this.processDate = processDate;
    }

    public int getProcessResult() {
        return processResult;
    }

    public void setProcessResult(int processResult) {
        this.processResult = processResult;
    }

    public String getProcessComment() {
        return processComment;
    }

    public void setProcessComment(String processComment) {
        this.processComment = processComment;
    }


    @Override
    public String toString() {
        return "AdminApproval{" +
                "id=" + id +
                ", applyId=" + applyId +
                ", handler='" + handler + '\'' +
                ", processDate=" + processDate +
                ", processResult=" + processResult +
                ", processComment='" + processComment + '\'' +
                '}';
    }
}
