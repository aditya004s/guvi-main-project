#Car Rental System
Overview
The Car Rental System is a Java-based application that allows users to manage the rental of cars. The system provides functionalities for adding new cars, viewing available cars, renting cars, and tracking rental history. It uses JDBC for database connectivity and MySQL as the database to store car and rental details.

Project Structure
The project is organized into the following main components:

Model: Contains Java classes that represent the business entities, such as Car and Rental.
DAO (Data Access Object): Includes classes for performing database operations related to cars (CarDAO) and rentals (RentalDAO).
Utility: A utility class (DBConnection) to handle database connections using JDBC.
Main Class: The Main.java file contains the entry point to the application where various functionalities of the system are executed.
Features
Car Management:
Add new cars to the inventory.
View available cars and their details (e.g., model, year, status).
Update car status (e.g., mark as rented or available).
Rental Management:
Rent a car by specifying customer details and rental period.
Track rental history, including customer name, rental date, and return date.
Database:
Uses MySQL as the backend database to store car and rental information.
The system maintains two main tables:
cars: Stores car details (ID, model, year, status).
rentals: Stores rental transactions (rental ID, car ID, customer name, rental dates).
Database Setup
The Car Rental System requires a MySQL database named CarRentalDB with two tables: cars for storing car information, and rentals for storing rental transactions. The system uses JDBC to connect to the database and perform CRUD (Create, Read, Update, Delete) operations.

Technologies Used
Java: The primary programming language used for implementing the system.
MySQL: A relational database management system for storing and retrieving car and rental data.
JDBC: Java Database Connectivity (JDBC) is used for connecting the Java application to the MySQL database.
IDE: The project can be developed and executed using Java IDEs like IntelliJ IDEA, Eclipse, or NetBeans.
Setup Instructions
Install JDK: Ensure you have JDK 8 or higher installed on your system.
Set Up MySQL: Install MySQL and create the database CarRentalDB by executing the provided SQL schema.
Configure JDBC: Download and add the MySQL JDBC driver (Connector/J) to the project’s classpath.
Update Database Credentials: Modify the database connection details in the DBConnection.java file with your MySQL username and password.
Run the Application: Compile and run the Main.java file to start interacting with the Car Rental System.
Conclusion
This Car Rental System demonstrates how to manage a simple car rental service, including the functionality to add cars, rent them, and manage rental transactions. It provides a practical example of how to use JDBC for database operations in Java, integrating basic CRUD functionality with a MySQL backend.
