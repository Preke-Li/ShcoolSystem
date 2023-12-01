package com.schoolsystem.service;

import com.schoolsystem.pojo.LeaveApply;

import java.util.List;

public interface LeaveService {

    void applyLeave(int studentId, String reason, int courseId, String beginDate, String endDate, String theme);

    List<LeaveApply> getLeaveProgress(int studentId);
}
