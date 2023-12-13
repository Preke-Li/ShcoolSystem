package com.schoolsystem.dao;

import com.schoolsystem.pojo.AdminApproval;
import com.schoolsystem.pojo.LeaveApply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LeaveMapper {

    @Insert("INSERT INTO leave_apply (student_id, reason, coures_id, begin_date, end_date, theme) " +
            "VALUES (#{studentId}, #{reason}, #{couresId}, #{beginDate}, #{endDate}, #{theme})")
    void applyLeave(LeaveApply leaveApply);

    @Select("SELECT * FROM leave_apply WHERE student_id = #{studentId}")
    List<LeaveApply> getLeaveProgress(int studentId);

    @Delete("DELETE FROM leave_apply WHERE id = #{leaveApplyId}")
    void deleteLeaveApply(int leaveApplyId);

    @Update("UPDATE leave_apply SET status = #{status} WHERE id = #{id}")
    void updateLeaveApplyStatus(LeaveApply leaveApply);


    @Select("SELECT * FROM leave_apply WHERE id = #{leaveApplyId}")
    LeaveApply getLeaveDetail(int leaveApplyId);


    @Select("SELECT * FROM leave_apply WHERE status =2")
    List<LeaveApply> getApply();
}
