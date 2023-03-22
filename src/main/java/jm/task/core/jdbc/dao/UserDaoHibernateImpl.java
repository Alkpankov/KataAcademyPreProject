package jm.task.core.jdbc.dao;

import com.mysql.cj.protocol.x.Notice;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        SessionFactory factory = getFactory();
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS " +
                    "users(id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(45) NOT NULL, lastname VARCHAR(45) " +
                    "NOT NULL, age INT);").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    @Override
    public void dropUsersTable() {
        SessionFactory factory = getFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE IF EXISTS users;")
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        SessionFactory factory = getFactory();
        try {
            Session session = factory.getCurrentSession();
            User user = new User(name, lastName, age);
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        SessionFactory factory = getFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        SessionFactory factory = getFactory();
        List<User> list = new ArrayList<>();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            list = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
        return list;
    }

    @Override
    public void cleanUsersTable() {
        SessionFactory factory = getFactory();
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete User").executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
