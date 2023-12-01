package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.LeaveMapper;
import com.schoolsystem.pojo.LeaveApply;
import com.schoolsystem.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeaveMapper leaveMapper;

    @Transactional  //
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

    // 日期转换工具类
    private static class DateUtils {
        public static Timestamp convertStringToTimestamp(String dateString) throws ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedDate = dateFormat.parse(dateString);
            return new Timestamp(parsedDate.getTime());
        }
    }
}
