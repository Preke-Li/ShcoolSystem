package com.schoolsystem.pojo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public  class Account {
    protected String username;
    protected String password;

    @Min(0)
    @Max(1)
    @NotNull
    protected Short position;
    protected Integer id=0;
}
