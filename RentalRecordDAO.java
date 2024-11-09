
package dao;

import models.RentalRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalRecordDAO {
    public void addRentalRecord(RentalRecord record) throws SQLException {
        String query = "INSERT INTO RentalRecord (car_id, customer_name, rental_date, return_date, total_cost) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, record.getCarId());
            stmt.setString(2, record.getCustomerName());
            stmt.setDate(3, record.getRentalDate());
            stmt.setDate(4, record.getReturnDate());
            stmt.setBigDecimal(5, record.getTotalCost());
            stmt.executeUpdate();
        }
    }

    public List<RentalRecord> getAllRentalRecords() throws SQLException {
        List<RentalRecord> records = new ArrayList<>();
        String query = "SELECT * FROM RentalRecord";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                RentalRecord record = new RentalRecord(rs.getInt("rental_id"), rs.getInt("car_id"),
                        rs.getString("customer_name"), rs.getDate("rental_date"), rs.getDate("return_date"),
                        rs.getBigDecimal("total_cost"));
                records.add(record);
            }
        }
        return records;
    }
}
