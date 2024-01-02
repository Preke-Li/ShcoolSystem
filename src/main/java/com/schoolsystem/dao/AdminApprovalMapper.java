package com.schoolsystem.dao;

import com.schoolsystem.pojo.AdminApproval;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminApprovalMapper {

    @Insert("INSERT INTO admin_approval (apply_id, handler,  process_result, process_comment) " +
            "VALUES (#{applyId}, #{handler},  #{processResult}, #{processComment})")
    void insertAdminApproval(AdminApproval adminApproval);

    @Select("SELECT * FROM admin_approval WHERE apply_id = #{leaveApplyId}")
    AdminApproval getAdminApproval(int leaveApplyId);
}