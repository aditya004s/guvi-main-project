package com.example.carrentalsystem.repository;

import com.example.carrentalsystem.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}

