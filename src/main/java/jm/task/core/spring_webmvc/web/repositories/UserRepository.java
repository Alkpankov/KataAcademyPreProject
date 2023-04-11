package jm.task.core.spring_webmvc.web.repositories;

import jm.task.core.spring_webmvc.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
