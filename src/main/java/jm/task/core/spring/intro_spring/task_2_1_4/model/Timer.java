package jm.task.core.spring.intro_spring.task_2_1_4.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Timer {

    private Long nanoTime = System.nanoTime();
    public Long getTime() {
        return nanoTime;
    }
}