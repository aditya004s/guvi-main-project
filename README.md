#Car Rental System
A simple Java-based application with a graphical user interface (GUI) to manage car rental records. This application allows users to add new car rentals and view all existing rentals in a user-friendly interface.

#Features:-
Add New Rental: Input fields for entering customer name, car model, rental date, and return date.
View Rentals: Display all saved rental records with an organized layout.
Persistent Storage: Saves rental data to a local rentals.txt file, so records persist between sessions.

#Code Overview
The application contains two main tabs:
1)Add Rental Tab: A form where users can input Customer Name, Car Model, Rental Date (format: YYYY-MM-DD), Return Date (format: YYYY-MM-DD)
2)View Rentals Tab: Displays all rental records in a table format, with columns for customer name, car model, rental date, and return date.

#How It Works
Add Rental Tab:Users input customer and rental information in a form.
Clicking Save Rental writes this data to rentals.txt in a comma-separated format.
A confirmation message appears, and the form clears for new entries.

View Rentals Tab:On selection, the program reads rentals.txt, parses each line, and displays the rental details in a formatted text area.The data is displayed in columns: Customer Name, Car Model, Rental Date, and Return Date.This structure makes it easy to add and retrieve rental data, with all records stored for future access.
