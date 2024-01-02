package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.AdminApprovalMapper;
import com.schoolsystem.dao.LeaveMapper;
import com.schoolsystem.pojo.AdminApproval;
import com.schoolsystem.pojo.LeaveApply;
import com.schoolsystem.service.AdminApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminApprovalServiceImpl implements AdminApprovalService {

    @Autowired
    private AdminApprovalMapper adminApprovalMapper;

    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    @Transactional
    public void processApproval(AdminApproval adminApproval) {
        adminApprovalMapper.insertAdminApproval(adminApproval);

        updateLeaveApplyStatus(adminApproval.getApplyId(), adminApproval.getProcessResult());

    }

    private void updateLeaveApplyStatus(int applyId, int result) {
        LeaveApply leaveApply = new LeaveApply();
        leaveApply.setId(applyId);
//        leaveApply = leaveMapper.getLeaveDetail(applyId);
        leaveApply.setStatus(result);
        leaveMapper.updateLeaveApplyStatus(leaveApply);
    }
}
