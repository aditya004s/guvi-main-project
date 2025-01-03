package com.example.carrentalsystem.service;

import com.example.carrentalsystem.model.Car;
import com.example.carrentalsystem.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllCars() {
        Car car1 = new Car();
        Car car2 = new Car();
        List<Car> cars = Arrays.asList(car1, car2);

        when(carRepository.findAll()).thenReturn(cars);

        List<Car> result = carService.getAllCars();

        assertEquals(2, result.size());
        verify(carRepository, times(1)).findAll();
    }

    @Test
    void getCarById() {
        Car car = new Car();
        car.setId(1L);

        when(carRepository.findById(1L)).thenReturn(Optional.of(car));

        Optional<Car> result = carService.getCarById(1L);

        assertEquals(true, result.isPresent());
        assertEquals(1L, result.get().getId());
        verify(carRepository, times(1)).findById(1L);
    }

    @Test
    void saveCar() {
        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Corolla");

        when(carRepository.save(car)).thenReturn(car);

        Car result = carService.saveCar(car);

        assertEquals("Toyota", result.getMake());
        assertEquals("Corolla", result.getModel());
        verify(carRepository, times(1)).save(car);
    }

    @Test
    void deleteCar() {
        carService.deleteCar(1L);
        verify(carRepository, times(1)).deleteById(1L);
    }
}

