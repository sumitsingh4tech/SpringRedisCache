package dev.sumit.SpringRedisCache.service;

import dev.sumit.SpringRedisCache.model.Car;

import java.util.List;


public interface CarService {
    Car getCar(int id);
    List<Car> getAllCars();
    Car saveCar(Car car);
    void deleteCar(int id);
    void deleteAll();
}
