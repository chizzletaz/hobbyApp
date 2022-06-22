package com.ilionx.carapp.persistence;

import com.ilionx.carapp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Iterable <Car> findCarByBrand(String brand);

    Iterable <Car> findByLicensePlate(String licensePlate);

    Iterable <Car> findCarByMileageGreaterThan(int mileage);



}
