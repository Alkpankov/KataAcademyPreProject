package jm.task.core.spring.spring_hibernate.task_2_2_1.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "uCar")
    private User user;

    public Car(){}
    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
