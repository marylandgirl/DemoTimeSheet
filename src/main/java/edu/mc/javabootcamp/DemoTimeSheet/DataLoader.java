package edu.mc.javabootcamp.DemoTimeSheet;

import edu.mc.javabootcamp.DemoTimeSheet.model.*;
import edu.mc.javabootcamp.DemoTimeSheet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ManagerRepository managerRepository;

    @Autowired
    TimeSheetRepository timeSheetRepository;

    @Autowired
    AccumulatedTimeBenefitRepository accumulatedTimeBenefitRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthoritiesRepository authoritiesRepository;


    @Override
    public void run(String... strings) throws Exception{

        Manager managerSue = new Manager();
        managerRepository.save(managerSue);



        Employee sue = new Employee("111-11-1111", "Han", "Sue",
                "sue@mc.edu", "7 Main Ave", "Potomac", "MD", "22222",
                150.00, managerSue, new HashSet<TimeSheet>());


        Employee kim = new Employee("222-22-2222", "Levin", "Kim",
                "kim@mc.edu", "9999 College Lane", "Rockville", "MD", "33333",
                100.00, managerSue, new HashSet<TimeSheet>());

        Employee ashu = new Employee("333-33-3333", "Maru", "Ashuashenafi",
                "ashu@mc.edu", "54321 Gold Street", "Germantown", "MD", "44444",
                100.00, managerSue, new HashSet<TimeSheet>());

        Employee bilen = new Employee("444-44-4444", "Worku", "Bilen",
                "bilen@mc.edu", "77777 Happy Street", "Vienna", "VA", "55555",
                100.00, managerSue, new HashSet<TimeSheet>());

        employeeRepository.save(sue);
        employeeRepository.save(kim);
        employeeRepository.save(ashu);
        employeeRepository.save(bilen);

        managerSue.setEmpId(sue.getId());
        managerRepository.save(managerSue);

        Set<Employee> employeeHashSet = new HashSet<Employee>();
        employeeHashSet = managerSue.getEmployeeSet();
        employeeHashSet.add(kim);
        employeeHashSet.add(ashu);
        employeeHashSet.add(bilen);
        managerSue.setEmployeeSet(employeeHashSet);
        managerRepository.save(managerSue);

        Authorities sueAuthority = new Authorities();
        sueAuthority.setAuthority("ROLE_USER");
        Set<Authorities> sueAuthorities = new HashSet<>();
        sueAuthorities.add(sueAuthority);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User uSue = new User("sue", encoder.encode("teacher"), true);
        sue = employeeRepository.findById(sue.getId());
        uSue.setEmployee(sue);
        uSue.setAuthorities(sueAuthorities);
        userRepository.save(uSue);
        sue.setUser(uSue);
        sueAuthority.setUser(uSue);
     /*   Authorities sueAuthority = new Authorities();
        sueAuthority.setAuthority("ROLE_USER");
        sueAuthority.setUser(uSue);*/
     /*   Set<Authorities> sueAuthorities = new HashSet<>();
        sueAuthorities.add(sueAuthority);*/
//        uSue.setAuthorities(sueAuthorities);
//        sue.setUser(uSue);
//        employeeRepository.save(sue);
      //  userRepository.save(uSue);
        employeeRepository.save(sue);
        authoritiesRepository.save(sueAuthority);




        TimeSheet sueTimeSheet = new TimeSheet(LocalDate.parse("2020-06-15"), LocalDate.parse("2020-06-21"), sue,
                40, 10, 0, 0, 0, 0,
                0, 0, 0, 0, "", true );
        timeSheetRepository.save(sueTimeSheet);

        TimeSheet ashuTimeSheet = new TimeSheet(LocalDate.parse("2020-06-15"), LocalDate.parse("2020-06-21"), ashu,
                40, 30, 0, 0, 0, 0,
                0, 10, 0, 0, "", true );
        timeSheetRepository.save(ashuTimeSheet);


        AccumulatedTimeBenefit ashuAccumulatedTimeBenefit = new AccumulatedTimeBenefit();
        ashuAccumulatedTimeBenefit.setCumCompTimeUsed(ashuTimeSheet.getGetCompTimeUsedHrs());
        accumulatedTimeBenefitRepository.save(ashuAccumulatedTimeBenefit);
        ashuAccumulatedTimeBenefit.setEmployee(ashu);
        accumulatedTimeBenefitRepository.save(ashuAccumulatedTimeBenefit);
        ashu = employeeRepository.findById(ashu.getId());
        ashu.setAccumulatedTimeBenefit(ashuAccumulatedTimeBenefit);
        employeeRepository.save(ashu);


        TimeSheet kimTimeSheet = new TimeSheet(LocalDate.parse("2020-06-15"), LocalDate.parse("2020-06-21"), kim,
                40, 4, 0, 0, 0, 0,
                8, 0, 8, 0, "", true );
        timeSheetRepository.save(kimTimeSheet);
        AccumulatedTimeBenefit kimAccumulatedTimeBenefit = new AccumulatedTimeBenefit();
        kimAccumulatedTimeBenefit.setCumAnnualLeaveUsed(kimTimeSheet.getAnnualLeaveHrs());
        accumulatedTimeBenefitRepository.save(kimAccumulatedTimeBenefit);
        kim = employeeRepository.findById(kim.getId());
        kimAccumulatedTimeBenefit.setEmployee(kim);
        accumulatedTimeBenefitRepository.save(kimAccumulatedTimeBenefit);
        kim.setAccumulatedTimeBenefit(kimAccumulatedTimeBenefit);
        employeeRepository.save(kim);


        TimeSheet bilenTimeSheet = new TimeSheet(LocalDate.parse("2020-06-15"), LocalDate.parse("2020-06-21"), bilen,
                32, 0, 0, 0, 0, 0,
                0, 0, 8, 0, "", true );
        timeSheetRepository.save(bilenTimeSheet);
    }
}
