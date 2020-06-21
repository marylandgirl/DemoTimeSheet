package edu.mc.javabootcamp.DemoTimeSheet.repository;

import edu.mc.javabootcamp.DemoTimeSheet.model.Authorities;
import org.springframework.data.repository.CrudRepository;

public interface AuthoritiesRepository extends CrudRepository<Authorities,Long> {
}
