package dev.sumit.SpringRedisCache.service;

import dev.sumit.SpringRedisCache.model.Car;
import dev.sumit.SpringRedisCache.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCar(int id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.get();
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveCar(Car car) {
        Car savedCar = carRepository.save(car);
        return savedCar;
    }

    @Override
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        carRepository.deleteAll();
    }
}
