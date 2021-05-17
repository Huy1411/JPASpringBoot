package com.example.enterprise_application.service;


import com.example.enterprise_application.jpa.Department;
import org.springframework.data.domain.Page;


import java.util.List;

public interface DepartmentService {
    List<Department> listDepartments();
    Department getDepartmentById(int department_id);
    boolean saveDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(int department_id);
    Page<Department> findPaginated(int pageNo, int pageSize);


}
