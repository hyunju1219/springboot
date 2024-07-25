package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarRepository {

    public Car findCarByModel(String model) {
        Car findCar = null;

        List<Car> cars = List.of(Car.builder().model("쏘나타").color("화이트").build(),
                                Car.builder().model("K5").color("블랙").build());

        return cars.stream()
                .filter(car -> car.getModel().equals(model))
                .collect(Collectors.toList())
                .get(0);

//        for(Car car : cars) {
//            if(car.getModel().equals(model)) {
//                findCar = car;
//                break;
//            }
//        }
//
//        return findCar;

    }
}
