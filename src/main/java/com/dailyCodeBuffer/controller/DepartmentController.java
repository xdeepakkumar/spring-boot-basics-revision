package com.dailyCodeBuffer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailyCodeBuffer.entity.Department;
import com.dailyCodeBuffer.exceptions.DepartmentNotFoundException;
import com.dailyCodeBuffer.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/all-department")
	public List<Department> fetchDepartmentList(){
		return departmentService.fetchDepartmentList();
	}
	
	@GetMapping("/departments/{departmentId}")
	public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId) throws DepartmentNotFoundException {
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{departmentId}")
	public String deleteDepartmentById(@PathVariable("departmentId") Long departmentId){
		departmentService.deleteDepartmentById(departmentId);
		return "Department Deleted Successfully.";
	}
	
	@PutMapping("/departments/{departmentId}")
	public Department updateDepartment(@PathVariable("departmentId") Long departmentId, @RequestBody Department department) {
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String name) {
		return departmentService.fetchDepartmentByName(name);
	}
}
