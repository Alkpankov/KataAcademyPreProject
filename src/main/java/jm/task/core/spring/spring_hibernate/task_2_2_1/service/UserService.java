package jm.task.core.spring.spring_hibernate.task_2_2_1.service;

import jm.task.core.spring.spring_hibernate.task_2_2_1.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User getUserByCar(String model, int series);
}
