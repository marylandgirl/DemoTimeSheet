package edu.mc.javabootcamp.DemoTimeSheet.model;

import javax.persistence.*;

@Entity
public class AccumulatedTimeBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double cumCompTimeEarned;
    private double cumCompTimeUsed;
    private double cumAnnualLeaveUsed;
    private double cumAnnualLeaveEarned;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public AccumulatedTimeBenefit() {
    }

    public AccumulatedTimeBenefit(double cumCompTimeEarned, double cumCompTimeUsed, double cumAnnualLeaveUsed,
                                  double cumAnnualLeaveEarned, Employee employee) {
        this.cumCompTimeEarned = cumCompTimeEarned;
        this.cumCompTimeUsed = cumCompTimeUsed;
        this.cumAnnualLeaveUsed = cumAnnualLeaveUsed;
        this.cumAnnualLeaveEarned = cumAnnualLeaveEarned;
        this.employee = employee;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCumCompTimeEarned() {
        return cumCompTimeEarned;
    }

    public void setCumCompTimeEarned(double cumCompTimeEarned) {
        this.cumCompTimeEarned = cumCompTimeEarned;
    }

    public double getCumCompTimeUsed() {
        return cumCompTimeUsed;
    }

    public void setCumCompTimeUsed(double cumCompTimeUsed) {
        this.cumCompTimeUsed = cumCompTimeUsed;
    }

    public double getCumAnnualLeaveUsed() {
        return cumAnnualLeaveUsed;
    }

    public void setCumAnnualLeaveUsed(double cumAnnualLeaveUsed) {
        this.cumAnnualLeaveUsed = cumAnnualLeaveUsed;
    }

    public double getCumAnnualLeaveEarned() {
        return cumAnnualLeaveEarned;
    }

    public void setCumAnnualLeaveEarned(double cumAnnualLeaveEarned) {
        this.cumAnnualLeaveEarned = cumAnnualLeaveEarned;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
