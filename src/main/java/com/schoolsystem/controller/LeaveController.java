package com.schoolsystem.controller;

import com.schoolsystem.pojo.LeaveApply;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.LeaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student/leave")
@Slf4j
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    // 3.1 请假申请
    @PostMapping("/apply")
    public Result applyLeave(@RequestBody Map<String, Object> requestData) {
        try {
            int studentId = (int) requestData.get("studentId");
            String reason = (String) requestData.get("reason");
            int courseId = (int) requestData.get("courseId");
            String beginDate = (String) requestData.get("beginDate");
            String endDate = (String) requestData.get("endDate");
            String theme = (String) requestData.get("theme");
            log.info(String.valueOf(requestData));
            leaveService.applyLeave(studentId, reason, courseId, beginDate, endDate, theme);
            return Result.success("请假申请成功");
        } catch (Exception e) {
            return Result.error("请假申请失败：" + e.getMessage());
        }
    }

    // 3.2 查看请假进度
    @GetMapping("/progress")
    public Result getLeaveProgress(@RequestParam int studentId) {
        try {
            // 调用服务层方法获取请假进度
            List<LeaveApply> leaveProgressList = leaveService.getLeaveProgress(studentId);
            return Result.success(leaveProgressList);
        } catch (Exception e) {
            return Result.error("查看请假进度失败：" + e.getMessage());
        }
    }

    // 3.3 删除请假申请
    @DeleteMapping("/delete")
    public Result deleteLeaveApply(@RequestParam int leaveApplyId) {
        try {
            leaveService.deleteLeaveApply(leaveApplyId);
            return Result.success("删除请假申请成功");
        } catch (Exception e) {
            return Result.error("删除请假申请失败：" + e.getMessage());
        }
    }

    @GetMapping("/detail")
    public Result getLeaveDetail(@RequestParam int leaveApplyId){
        try {
            LeaveApply leaveDetail = leaveService.getLeaveDetail(leaveApplyId);
            return Result.success(leaveDetail);
        } catch (Exception e) {
            return Result.error("获取请假详情失败：" + e.getMessage());
        }
    }

    @GetMapping("/detailWithApproval")
    public Result getLeaveDetailWithApproval(@RequestParam int leaveApplyId){
        try {
            Map<String, Object> leaveDetailWithApproval = leaveService.getLeaveDetailWithApproval(leaveApplyId);
            return Result.success(leaveDetailWithApproval);
        } catch (Exception e) {
            return Result.error("获取请假详情和审批信息失败：" + e.getMessage());
        }
    }


}
