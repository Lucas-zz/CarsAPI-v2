package com.carsapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carsapi.api.model.CarModel;

public interface CarRepository extends JpaRepository<CarModel, Long> {

}
