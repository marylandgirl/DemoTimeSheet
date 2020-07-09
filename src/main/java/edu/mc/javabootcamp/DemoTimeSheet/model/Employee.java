package edu.mc.javabootcamp.DemoTimeSheet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String ssn;

    @NotNull
    private String lastName;

    @NotNull
    private String firstName;
    private String email;
    private String strAddr;
    private String city;
    private String state;
    private String zip;
    private double payRate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "employee", cascade = {CascadeType.MERGE, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Set<TimeSheet> timeSheetSet;

    @OneToOne(mappedBy = "employee")
    private AccumulatedTimeBenefit accumulatedTimeBenefit;

    @OneToOne(mappedBy = "employee")
    private User user;

    public Employee() {
        manager = new Manager();
        timeSheetSet = new HashSet<TimeSheet>();
        accumulatedTimeBenefit = new AccumulatedTimeBenefit();
    }

    public Employee(String ssn, String lastName, String firstName, String email, String strAddr,
                    String city, String state, String zip, double payRate, Manager manager,
                    Set<TimeSheet> timeSheetSet) {
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.strAddr = strAddr;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.payRate = payRate;
        this.manager = manager;
        this.timeSheetSet = timeSheetSet;;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStrAddr() {
        return strAddr;
    }

    public void setStrAddr(String strAddr) {
        this.strAddr = strAddr;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Set<TimeSheet> getTimeSheetSet() {
        return timeSheetSet;
    }

    public void setTimeSheetSet(Set<TimeSheet> timeSheetSet) {
        this.timeSheetSet = timeSheetSet;
    }

    public AccumulatedTimeBenefit getAccumulatedTimeBenefit() {
        return accumulatedTimeBenefit;
    }

    public void setAccumulatedTimeBenefit(AccumulatedTimeBenefit accumulatedTimeBenefit) {
        this.accumulatedTimeBenefit = accumulatedTimeBenefit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
