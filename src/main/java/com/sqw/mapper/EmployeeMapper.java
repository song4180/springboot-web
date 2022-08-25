package com.sqw.mapper;
import com.sqw.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;


//员工Dao
@Mapper
@Repository
public interface EmployeeMapper {

    //数据操作
    List<Employee> queryEmployeeList();
    Employee queryEmployeeById(int id);
    int addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    int deleteEmployeeById(int id);
}
