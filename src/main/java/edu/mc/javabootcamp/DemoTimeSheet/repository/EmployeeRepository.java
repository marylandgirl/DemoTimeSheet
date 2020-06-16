package edu.mc.javabootcamp.DemoTimeSheet.repository;

import edu.mc.javabootcamp.DemoTimeSheet.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
