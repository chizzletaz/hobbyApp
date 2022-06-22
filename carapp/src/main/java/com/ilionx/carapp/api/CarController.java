package com.ilionx.carapp.api;

import com.ilionx.carapp.model.Car;
import com.ilionx.carapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> list() {
        return ResponseEntity.ok(carService.findAll());
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @GetMapping("{id}")
    public ResponseEntity<Car> findById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carService.findById(id);
        if(optionalCar.isPresent()) {
            return ResponseEntity.ok(optionalCar.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("brand/{brand}")
    public ResponseEntity<Iterable<Car>> findByBrand(@PathVariable String brand) {
            return ResponseEntity.ok(carService.findCarByBrand(brand));
    }

    @GetMapping("license/{licenseplate}")
    public ResponseEntity<Iterable<Car>> findByLicensePLate(@PathVariable String licenseplate) {
            return ResponseEntity.ok(carService.findCarByLicensePlate(licenseplate));
    }

    @GetMapping("mileage/{mileage}")
    public ResponseEntity<Iterable<Car>> findByMileageGreaterThan(@PathVariable int mileage) {
            return ResponseEntity.ok(carService.findCarByMileageGreaterThan(mileage));

    }
    @PutMapping("{id}")
    public ResponseEntity<Car> updateById(@PathVariable long id, @RequestBody Car source) {
        Optional<Car> optionalCar = this.carService.findById(id);
        if (optionalCar.isPresent()) {
            return ResponseEntity.ok(carService.updateByID(id, source));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Optional<Car> optionalCar = this.carService.findById(id);
        if(optionalCar.isPresent()) {
            carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
