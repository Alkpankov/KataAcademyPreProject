package jm.task.core.spring.spring_hibernate.task_2_2_1;


import jm.task.core.spring.spring_hibernate.task_2_2_1.config.AppConfig;
import jm.task.core.spring.spring_hibernate.task_2_2_1.model.Car;
import jm.task.core.spring.spring_hibernate.task_2_2_1.model.User;
import jm.task.core.spring.spring_hibernate.task_2_2_1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new User("User1", "Lastname1",
              "user1@mail.ru", new Car("TeslaModelOne")));
      userService.add(new User("User2", "Lastname2",
              "user2@mail.ru", new Car("FordFocus")));
      userService.add(new User("User3", "Lastname3",
              "user3@mail.ru", new Car("AudyQ6")));
      userService.add(new User("User4", "Lastname4",
              "user4@mail.ru", new Car("ShkodaOktavia")));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.print(user.getCar().toString());
         System.out.println();
      }
      User user11 = userService.getUserByCar("AudyQ6", 3);
      System.out.println("Id = " + user11.getId());
      System.out.println("First Name = " + user11.getFirstName());
      System.out.println("Last Name = " + user11.getLastName());
      System.out.println("Email = " + user11.getEmail());
      context.close();
   }

}
