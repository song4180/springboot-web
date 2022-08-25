package com.sqw.controller;

import com.sqw.mapper.DepartmentMapper;
import com.sqw.mapper.EmployeeMapper;
import com.sqw.pojo.Department;
import com.sqw.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeDao;
    @Autowired
    DepartmentMapper departmentDao;


    @RequestMapping("/emps")
    public String list(Model model){
        List<Employee> employees=employeeDao.queryEmployeeList();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddEmpPage(Model model){
        //查询部门信息
        List<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加操作
        employeeDao.addEmployee(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        //获取用户ID
        Employee employee =employeeDao.queryEmployeeById(id);
        model.addAttribute("emp",employee);
        //查询部门信息
        List<Department> departments=departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/update";
    }
    @PostMapping("/updateemp")
    public String updateEmp(Employee employee){
        //添加操作
        employeeDao.updateEmployee(employee);
        return "redirect:/emps";
    }
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        //获取用户ID
        Employee employee =employeeDao.queryEmployeeById(id);
        employeeDao.deleteEmployeeById(employee.getId());
        return "redirect:/emps";
    }
}
