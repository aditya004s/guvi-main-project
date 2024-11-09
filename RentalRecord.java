
package models;

import java.math.BigDecimal;
import java.sql.Date;

public class RentalRecord {
    private int rentalId;
    private int carId;
    private String customerName;
    private Date rentalDate;
    private Date returnDate;
    private BigDecimal totalCost;

    public RentalRecord(int rentalId, int carId, String customerName, Date rentalDate, Date returnDate, BigDecimal totalCost) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.customerName = customerName;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    public int getRentalId() { return rentalId; }
    public int getCarId() { return carId; }
    public String getCustomerName() { return customerName; }
    public Date getRentalDate() { return rentalDate; }
    public Date getReturnDate() { return returnDate; }
    public BigDecimal getTotalCost() { return totalCost; }
}
