package com.carsapi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carsapi.api.dto.CarDTO;
import com.carsapi.api.model.CarModel;
import com.carsapi.api.repository.CarRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarsController {

    @Autowired
    private CarRepository repository;

    @GetMapping
    public List<CarModel> getCars() {
        return repository.findAll();
    }

    @PostMapping
    public String createCar(@RequestBody @Valid CarDTO req) {
        repository.save(new CarModel(req));

        return "Created";
    }

    @PutMapping("/{id}")
    public String updateCar(@PathVariable Long id, @RequestBody @Valid CarDTO req) {
        repository.findById(id).map(car -> {
            car.setModelo(req.modelo());
            car.setFabricante(req.fabricante());
            car.setDataFabricacao(req.dataFabricacao());
            car.setAnoModelo(req.anoModelo());
            return repository.save(car);
        });

        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable Long id) {
        repository.deleteById(id);

        return "Deleted";
    }
}
