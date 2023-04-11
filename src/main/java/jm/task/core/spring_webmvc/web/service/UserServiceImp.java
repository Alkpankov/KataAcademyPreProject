package jm.task.core.spring_webmvc.web.service;

import jm.task.core.spring_webmvc.web.dao.UserDao;
import jm.task.core.spring_webmvc.web.model.User;
import jm.task.core.spring_webmvc.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService{
    private final UserRepository userRepository;
    private final UserDao userDao;
    @Autowired
    public UserServiceImp(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
//        return userRepository.findAll();
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void add(User user) {
//        userRepository.save(user);
        userDao.add(user);
    }
    @Transactional
    @Override
    public void update(long id, User updatedUser) {
//        updatedUser.setId(id);
//        userRepository.save(updatedUser);
        userDao.update(id, updatedUser);
    }
    @Transactional
    @Override
    public void delete(long id) {
//        userRepository.deleteById(id);
        userDao.delete(id);
    }

    @Override
    public User get(long id) {
//        Optional<User> user = userRepository.findById(id);
//        return user.orElse(null);
        return userDao.get(id);
    }
}
