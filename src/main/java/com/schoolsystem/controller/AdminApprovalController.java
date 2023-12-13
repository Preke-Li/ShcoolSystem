package com.schoolsystem.controller;

import com.schoolsystem.pojo.AdminApproval;
import com.schoolsystem.pojo.BookTransaction;
import com.schoolsystem.pojo.LeaveApply;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.AdminApprovalService;
import com.schoolsystem.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin/approval")
public class AdminApprovalController {
    @Autowired
    private AdminApprovalService adminApprovalService;

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/applyList")
    public Result getApply(){
        try {
            List<LeaveApply> leaveApply = leaveService.getApply();
            return Result.success(leaveApply);
        } catch (Exception e) {
            return Result.error("获取请假列表失败：" + e.getMessage());
        }
    }

    // 管理员审批
    @PostMapping("/process")
    public Result processApproval(@RequestBody Map<String, Object> requestData) {
        try {
            int applyId = (int) requestData.get("applyId");
            String handler = (String) requestData.get("handler");
            int processResult = (int) requestData.get("processResult");
            String processComment = (String) requestData.get("processComment");

            AdminApproval adminApproval = new AdminApproval(applyId, handler, processResult, processComment);
            adminApprovalService.processApproval(adminApproval);

            return Result.success("审批成功");
        } catch (Exception e) {
            return Result.error("审批失败：" + e.getMessage());
        }
    }
}
