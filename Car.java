
package models;

import java.math.BigDecimal;

public class Car {
    private int carId;
    private String make;
    private String model;
    private int year;
    private BigDecimal dailyRate;
    private boolean available;

    public Car(int carId, String make, String model, int year, BigDecimal dailyRate, boolean available) {
        this.carId = carId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.dailyRate = dailyRate;
        this.available = available;
    }

    public int getCarId() { return carId; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public BigDecimal getDailyRate() { return dailyRate; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }
}
