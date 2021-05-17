package com.example.enterprise_application.service.Impl;

import com.example.enterprise_application.jpa.Department;
import com.example.enterprise_application.repository.DepartmentRepository;
import com.example.enterprise_application.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> listDepartments(){
        try{
            List<Department> departments = departmentRepository.findAll();
            return departments;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Department getDepartmentById(int department_id) {
        try{
            Department department = departmentRepository.findById(department_id).get();
            return department;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveDepartment(Department department) {
        try{
            departmentRepository.save(department);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department) {
        try{
            departmentRepository.save(department);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int department_id) {
        try{
            Department department = departmentRepository.findById(department_id).get();
            departmentRepository.save(department);
            return true;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Page<Department> findPaginated(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return this.departmentRepository.findPaginateDepartments(pageable);
    }


}
