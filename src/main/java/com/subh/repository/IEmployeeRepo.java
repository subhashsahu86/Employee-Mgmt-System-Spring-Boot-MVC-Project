package com.subh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.subh.model.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
