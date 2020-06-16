package edu.mc.javabootcamp.DemoTimeSheet.repository;

import edu.mc.javabootcamp.DemoTimeSheet.model.Manager;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepository extends CrudRepository<Manager,Long> {
}
