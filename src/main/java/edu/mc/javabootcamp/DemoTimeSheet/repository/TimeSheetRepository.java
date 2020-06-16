package edu.mc.javabootcamp.DemoTimeSheet.repository;

import edu.mc.javabootcamp.DemoTimeSheet.model.TimeSheet;
import org.springframework.data.repository.CrudRepository;

public interface TimeSheetRepository extends CrudRepository<TimeSheet, Long> {
}
