package jm.task.core.spring.intro_spring.task_2_1_5.config;

import jm.task.core.spring.intro_spring.task_2_1_5.models.Deth8;
import jm.task.core.spring.intro_spring.task_2_1_5.models.Island2;
import jm.task.core.spring.intro_spring.task_2_1_5.models.Needle7;
import jm.task.core.spring.intro_spring.task_2_1_5.models.Wood3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "jm.task.core.spring.intro_spring.task_2_1_5")
public class AppConfig {

    @Bean
    public static Island2 getIsland(Wood3 wood) {
        return new Island2(wood);
    }

    @Bean
    public static Needle7 getNeedle(Deth8 deth) {
        return new Needle7(deth);
    }
}
