package com.dailyCodeBuffer.service;

import java.util.List;
import java.util.Optional;

import com.dailyCodeBuffer.entity.Department;
import com.dailyCodeBuffer.exceptions.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String name);

}
