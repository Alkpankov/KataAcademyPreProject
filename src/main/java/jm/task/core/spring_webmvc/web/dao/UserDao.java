package jm.task.core.spring_webmvc.web.dao;

import jm.task.core.spring_webmvc.web.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void update(long id, User user);
    void delete(long id);
    User get (long id);
}
