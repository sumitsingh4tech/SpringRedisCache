package dev.sumit.SpringRedisCache.controller;

import dev.sumit.SpringRedisCache.model.Car;
import dev.sumit.SpringRedisCache.service.CarService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Cacheable(value = "car")
    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable("id") int id){
        return carService.getCar(id);
    }

    @Cacheable(value = "car")
    @GetMapping("/car")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @CachePut(value = "car", key = "#car.id", unless = "#car.brand == null")
    @PostMapping("/car")
    public Car saveCar(@RequestBody Car car){
        return carService.saveCar(car);
    }

    @CachePut(value = "car", key = "#car.id", unless = "#car.brand == null")
    @PutMapping("/car/{id}")
    public Car updateCar(@PathVariable("id") int carId, @RequestBody Car car){
        //call service and update details for the given id
        return null;
    }

    @CacheEvict(value = "car", key = "#car.id")
    @DeleteMapping("/car/{id}")
    public Car deleteCar(@PathVariable("id") int carId) {
        Car c = carService.getCar(carId);
        carService.deleteCar(carId);
        return c;
    }
}
