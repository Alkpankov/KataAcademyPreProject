package jm.task.core.spring_webmvc.web.service;

import jm.task.core.spring_webmvc.web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    private List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
        cars.add(new Car("TeslaModelOne", 911, "A123BC"));
        cars.add(new Car("FordFocus", 2, "Q567WE"));
        cars.add(new Car("ShkodaOktavia", 513, "A832SD"));
        cars.add(new Car("PorsheCayen", 777, "Z329XC"));
        cars.add(new Car("AudyQ6", 533, "P947LM"));
    }

    public List<Car> getCars(Integer count) {
        if (count > 5) return cars;
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
