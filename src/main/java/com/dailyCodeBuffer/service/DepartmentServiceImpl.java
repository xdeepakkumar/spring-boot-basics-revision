package com.dailyCodeBuffer.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailyCodeBuffer.entity.Department;
import com.dailyCodeBuffer.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).orElse(null);
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department deptDB = departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName()) && ! "".equalsIgnoreCase(department.getDepartmentName())) {
			deptDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && ! "".equalsIgnoreCase(department.getDepartmentCode())) {
			deptDB.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && ! "".equalsIgnoreCase(department.getDepartmentAddress())) {
			deptDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(deptDB);
	}

	@Override
	public Department fetchDepartmentByName(String name) {
		return departmentRepository.findByDepartmentName(name);
	}

}
