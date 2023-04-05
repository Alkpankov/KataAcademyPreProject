package jm.task.core.spring_webmvc.web.controller;

import jm.task.core.spring_webmvc.web.model.Car;
import jm.task.core.spring_webmvc.web.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CarController {

    @GetMapping("/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") Integer countCars, Model model){
        CarService carService = new CarService();
        List<Car> list = carService.getCars(countCars);
        model.addAttribute("list", list);
        return "cars";
    }
}
