package jm.task.core.spring.spring_hibernate.task_2_2_1.dao;

import jm.task.core.spring.spring_hibernate.task_2_2_1.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUserByCar(String model, int series) {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User" +
              " as user where user.uCar.model = :model and user.uCar.series = :series");
      query.setParameter("model", model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }
}
