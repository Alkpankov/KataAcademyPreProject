package jm.task.core.spring.intro_spring.task_2_1_4;

import jm.task.core.spring.intro_spring.task_2_1_4.config.AppConfig;
import jm.task.core.spring.intro_spring.task_2_1_4.model.AnimalsCage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        for (int i = 0; i < 5; i++) {
            AnimalsCage bean =
                    applicationContext.getBean(AnimalsCage.class);
            bean.whatAnimalSay();
        }
    }

}
