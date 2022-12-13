package com.example.repository.employee;

import com.example.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select e.* from `employee` e where e.`status`=1 ", nativeQuery = true)
    List<Employee> findAll();

}
