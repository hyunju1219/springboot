package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {


    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        return carService.getCar(model);

    }

    @ResponseBody
    @GetMapping("/car1")
    public String getCar1() {
        return "자동차";
    }
}
//CarRepository carRepository = new CarRepository();
//CarService carService = new CarService(carRepository);
//CarController c = new CarController(carService);


/*
요청 GET - /car?model=?
CarEntity -> model, color

CarRepository -> Car findCarByModel(String model)
    -> List<Car>
        -> index0: Car(model: "쏘나타", color:"화이트")
        -> index1: Car(model: "k5", color:"블랙")

CarService -> Car getCar(String model)

CarController -> Car getCar(@RequestParam String model)

CarController > CarService > CarRepository
 */