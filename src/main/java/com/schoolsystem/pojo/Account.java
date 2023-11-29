package com.schoolsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public  class Account {
    protected String username;
    protected String password;
    protected Short position;
    protected Integer id=0;
}
