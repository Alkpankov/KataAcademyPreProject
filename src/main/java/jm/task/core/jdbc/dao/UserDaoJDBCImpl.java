package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jm.task.core.jdbc.util.Util.getConnection;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = getConnection();
    private String sqlComand;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        sqlComand = "CREATE TABLE IF NOT EXISTS users(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45) NOT NULL, lastname VARCHAR(45) NOT NULL, age INT);";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sqlComand);
        } catch (SQLException e) {
            System.err.println("Ошибка создания таблицы!");
            throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        sqlComand = "DROP TABLE IF EXISTS users;";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sqlComand);
        } catch (SQLException e) {
            System.err.println("Ошибка удаления таблицы!");
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        sqlComand = "INSERT INTO users(name, lastname, age) VALUES(?, ?, ?);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlComand)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка сохранения пользователя!");
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        sqlComand = "DELETE FROM users WHERE id = ?;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlComand)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ошибка удаления пользователя по ID!");
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        sqlComand = "SELECT * FROM users";
        try(Statement statement = connection.createStatement()) {
            ResultSet result = statement.executeQuery(sqlComand);
            while (result.next()) {
                User user = new User();
                user.setId((long) result.getInt(1));
                user.setName(result.getString(2));
                user.setLastName(result.getString(3));
                user.setAge(result.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка получения списка всех пользователей!");
            throw new RuntimeException(e);
        }
        return list;
    }

    public void cleanUsersTable() {
        sqlComand = "DELETE FROM users";
        try(Statement statement = connection.createStatement()) {
            statement.execute(sqlComand);
        } catch (SQLException e) {
            System.err.println("Ошибка очистки таблицы!");
            throw new RuntimeException(e);
        }
    }
}
