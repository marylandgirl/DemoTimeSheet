package edu.mc.javabootcamp.DemoTimeSheet.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String ssn;
    private String lastName;
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

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<TimeSheet> timeSheetSet;

    @OneToOne(mappedBy = "employee")
    private AccumulatedTimeBenefit accumulatedTimeBenefit;

    public Employee() {
        manager = new Manager();
        timeSheetSet = new HashSet<TimeSheet>();
        accumulatedTimeBenefit = new AccumulatedTimeBenefit();
    }

    public Employee(String username, String ssn, String lastName, String firstName, String email,
                    String strAddr, String city, String state, String zip, double payRate,
                    Manager manager, Set<TimeSheet> timeSheetSet) {
        super();
        this.username = username;
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
        this.timeSheetSet = timeSheetSet;
        this.accumulatedTimeBenefit = accumulatedTimeBenefit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
