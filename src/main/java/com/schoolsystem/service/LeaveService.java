package com.schoolsystem.service;

import com.schoolsystem.pojo.LeaveApply;

import java.util.List;
import java.util.Map;

public interface LeaveService {

    void applyLeave(int studentId, String reason, int courseId, String beginDate, String endDate, String theme);

    List<LeaveApply> getLeaveProgress(int studentId);

    void deleteLeaveApply(int leaveApplyId);

    LeaveApply getLeaveDetail(int leaveApplyId);

    Map<String, Object> getLeaveDetailWithApproval(int leaveApplyId);
}
