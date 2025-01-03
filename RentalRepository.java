package com.example.carrentalsystem.repository;

import com.example.carrentalsystem.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}

