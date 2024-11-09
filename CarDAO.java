
package dao;

import models.Car;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public void addCar(Car car) throws SQLException {
        String query = "INSERT INTO Car (make, model, year, daily_rate, availability) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, car.getMake());
            stmt.setString(2, car.getModel());
            stmt.setInt(3, car.getYear());
            stmt.setBigDecimal(4, car.getDailyRate());
            stmt.setBoolean(5, car.isAvailable());
            stmt.executeUpdate();
        }
    }

    public List<Car> getAllCars() throws SQLException {
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM Car";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Car car = new Car(rs.getInt("car_id"), rs.getString("make"), rs.getString("model"),
                        rs.getInt("year"), rs.getBigDecimal("daily_rate"), rs.getBoolean("availability"));
                cars.add(car);
            }
        }
        return cars;
    }

    public void updateCarAvailability(int carId, boolean availability) throws SQLException {
        String query = "UPDATE Car SET availability = ? WHERE car_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setBoolean(1, availability);
            stmt.setInt(2, carId);
            stmt.executeUpdate();
        }
    }
}
