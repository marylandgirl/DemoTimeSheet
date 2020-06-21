package edu.mc.javabootcamp.DemoTimeSheet.repository;

import edu.mc.javabootcamp.DemoTimeSheet.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
