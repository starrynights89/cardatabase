package com.packt.cardatabase.web;

import com.packt.cardatabase.domain.Car;

import com.packt.cardatabase.domain.CarReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private CarReposity reposity;


    @RequestMapping("/cars")
    public Iterable<Car> getCars() {
        return reposity.findAll();
    }

    /*
    @RequestMapping("/")
    public String home() {
        return "Hello world";
    } */
}
