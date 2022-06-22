package com.ilionx.carapp.service;

import com.ilionx.carapp.api.CarController;
import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.persistence.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;


    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car save(Car entity) {
        return carRepository.save(entity);
    }

    public Optional<Car> findById(Long aLong) {
        return carRepository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        carRepository.deleteById(aLong);
    }

    public Iterable<Car> findCarByBrand(String brand) {
        return carRepository.findCarByBrand(brand);
    }

    public Iterable<Car> findCarByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }

    public Iterable<Car> findCarByMileageGreaterThan(int mileage) {
        return carRepository.findCarByMileageGreaterThan(mileage);
    }

    public Car updateByID(long id, Car source) {
        Optional<Car> optionalCar = findById(id);
            Car target = optionalCar.get();
            target.setBrand(source.getBrand());
            target.setLicensePlate(source.getLicensePlate());
            target.setMileage(source.getMileage());

            return save(target);
    }
}
