package edu.mc.javabootcamp.DemoTimeSheet.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TimeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private double regHours;
    private double overTimeHrs;
    private double holidayHrs;
    private double holidayWrkdHrs;
    private double holidayOTHrs;
    private double leaveNoPayHrs;
    private double compTimeEarnedHrs;
    private double getCompTimeUsedHrs;
    private double annualLeaveHrs;
    private int rejCode;        //Unapproved=0, Approved=1, Rejected=-1
    private String rejMsg;
    private Boolean enabled;

    public TimeSheet() {
    }

    public TimeSheet(LocalDate startDate, LocalDate endDate, Employee employee, double regHours,
                     double overTimeHrs, double holidayHrs, double holidayWrkdHrs, double holidayOTHrs,
                     double leaveNoPayHrs, double compTimeEarnedHrs, double getCompTimeUsedHrs,
                     double annualLeaveHrs, int rejCode, String rejMsg, Boolean enabled) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
        this.regHours = regHours;
        this.overTimeHrs = overTimeHrs;
        this.holidayHrs = holidayHrs;
        this.holidayWrkdHrs = holidayWrkdHrs;
        this.holidayOTHrs = holidayOTHrs;
        this.leaveNoPayHrs = leaveNoPayHrs;
        this.compTimeEarnedHrs = compTimeEarnedHrs;
        this.getCompTimeUsedHrs = getCompTimeUsedHrs;
        this.annualLeaveHrs = annualLeaveHrs;
        this.rejCode = rejCode;
        this.rejMsg = rejMsg;
        this.enabled = enabled;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getRegHours() {
        return regHours;
    }

    public void setRegHours(double regHours) {
        this.regHours = regHours;
    }

    public double getOverTimeHrs() {
        return overTimeHrs;
    }

    public void setOverTimeHrs(double overTimeHrs) {
        this.overTimeHrs = overTimeHrs;
    }

    public double getHolidayHrs() {
        return holidayHrs;
    }

    public void setHolidayHrs(double holidayHrs) {
        this.holidayHrs = holidayHrs;
    }

    public double getHolidayWrkdHrs() {
        return holidayWrkdHrs;
    }

    public void setHolidayWrkdHrs(double holidayWrkdHrs) {
        this.holidayWrkdHrs = holidayWrkdHrs;
    }

    public double getHolidayOTHrs() {
        return holidayOTHrs;
    }

    public void setHolidayOTHrs(double holidayOTHrs) {
        this.holidayOTHrs = holidayOTHrs;
    }

    public double getLeaveNoPayHrs() {
        return leaveNoPayHrs;
    }

    public void setLeaveNoPayHrs(double leaveNoPayHrs) {
        this.leaveNoPayHrs = leaveNoPayHrs;
    }

    public double getCompTimeEarnedHrs() {
        return compTimeEarnedHrs;
    }

    public void setCompTimeEarnedHrs(double compTimeEarnedHrs) {
        this.compTimeEarnedHrs = compTimeEarnedHrs;
    }

    public double getGetCompTimeUsedHrs() {
        return getCompTimeUsedHrs;
    }

    public void setGetCompTimeUsedHrs(double getCompTimeUsedHrs) {
        this.getCompTimeUsedHrs = getCompTimeUsedHrs;
    }

    public double getAnnualLeaveHrs() {
        return annualLeaveHrs;
    }

    public void setAnnualLeaveHrs(double annualLeaveHrs) {
        this.annualLeaveHrs = annualLeaveHrs;
    }

    public int getRejCode() {
        return rejCode;
    }

    public void setRejCode(int rejCode) {
        this.rejCode = rejCode;
    }

    public String getRejMsg() {
        return rejMsg;
    }

    public void setRejMsg(String rejMsg) {
        this.rejMsg = rejMsg;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
