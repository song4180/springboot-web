package com.sqw.mapper;

import com.sqw.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//部门Dao
@Mapper
@Repository
public interface DepartmentMapper {
    //数据操作
    List<Department> getDepartments();
    Department getDepartmentById(int id);
}
