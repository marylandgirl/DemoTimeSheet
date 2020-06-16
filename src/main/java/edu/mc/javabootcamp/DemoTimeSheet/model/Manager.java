package edu.mc.javabootcamp.DemoTimeSheet.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long empId;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employeeSet;

    public Manager() {
        employeeSet = new HashSet<>();
    }

    public Manager(long empId, Set<Employee> employeeSet) {
        super();
        this.empId = empId;
        this.employeeSet = employeeSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}
