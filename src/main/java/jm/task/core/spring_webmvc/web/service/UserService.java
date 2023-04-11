package jm.task.core.spring_webmvc.web.service;

import jm.task.core.spring_webmvc.web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void update(long id, User user);
    void delete(long id);
    User get (long id);
}
