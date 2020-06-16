package edu.mc.javabootcamp.DemoTimeSheet;

import edu.mc.javabootcamp.DemoTimeSheet.model.Employee;
import edu.mc.javabootcamp.DemoTimeSheet.model.Manager;
import edu.mc.javabootcamp.DemoTimeSheet.repository.EmployeeRepository;
import edu.mc.javabootcamp.DemoTimeSheet.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void run(String... strings) throws Exception{

        Manager managerSue = new Manager();
        managerRepository.save(managerSue);

        Employee sue = new Employee("sue", "111-11-1111", "Han", "Sue", "sue@mc.edu", 100.00, managerSue);
        employeeRepository.save(sue);

        managerSue.setEmpId(sue.getId());
        managerRepository.save(managerSue);
    }
}
