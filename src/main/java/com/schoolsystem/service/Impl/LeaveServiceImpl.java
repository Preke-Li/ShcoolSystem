package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.AdminApprovalMapper;
import com.schoolsystem.dao.LeaveMapper;
import com.schoolsystem.pojo.LeaveApply;
import com.schoolsystem.pojo.AdminApproval;
import com.schoolsystem.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Autowired
    private AdminApprovalMapper adminApprovalMapper;

    @Transactional
    @Override
    public void applyLeave(int studentId, String reason, int courseId, String beginDate, String endDate, String theme) {
        // 创建 LeaveApply 对象并设置参数
        LeaveApply leaveApply = new LeaveApply();
        leaveApply.setStudentId(studentId);
        leaveApply.setReason(reason);
        leaveApply.setCouresId(courseId);

        try {
            leaveApply.setBeginDate(DateUtils.convertStringToTimestamp(beginDate));
            leaveApply.setEndDate(DateUtils.convertStringToTimestamp(endDate));
        } catch (ParseException e) {
            e.printStackTrace();
            // 处理日期转换异常
        }

        leaveApply.setTheme(theme);

        // 调用 leaveMapper 插入数据
        leaveMapper.applyLeave(leaveApply);
    }

    @Override
    public List<LeaveApply> getLeaveProgress(int studentId) {
        // 调用 leaveMapper 查询请假进度数据
        return leaveMapper.getLeaveProgress(studentId);
    }

    @Transactional
    @Override
    public void deleteLeaveApply(int leaveApplyId) {
        // 调用 leaveMapper 删除请假申请
        leaveMapper.deleteLeaveApply(leaveApplyId);
    }

    @Override
    public LeaveApply getLeaveDetail(int leaveApplyId) {
        // 调用 leaveMapper 获取请假详情
        return leaveMapper.getLeaveDetail(leaveApplyId);
    }

    @Override
    public Map<String, Object> getLeaveDetailWithApproval(int leaveApplyId) {
        // 调用 leaveMapper 获取请假详情和审批信息
        LeaveApply leaveApply = leaveMapper.getLeaveDetail(leaveApplyId);
        AdminApproval adminApproval = adminApprovalMapper.getAdminApproval(leaveApplyId);

        Map<String, Object> leaveDetailWithApproval = new HashMap<>();
        leaveDetailWithApproval.put("leaveApply", leaveApply);
        leaveDetailWithApproval.put("adminApproval", adminApproval);

        return leaveDetailWithApproval;
    }

    // 日期转换工具类
    private static class DateUtils {
        public static Timestamp convertStringToTimestamp(String dateString) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        }
    }

    @Override
    public  List<LeaveApply> getApply(){
        return leaveMapper.getApply();
    }
}
