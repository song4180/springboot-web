package com.sqw.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//员工表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int id;
    private String lastName;
    private String email;
    private Integer gender;// 0女 1男
    private String department;
    private Date birth;
}
