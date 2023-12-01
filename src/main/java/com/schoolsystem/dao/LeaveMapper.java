package com.schoolsystem.dao;

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
}
