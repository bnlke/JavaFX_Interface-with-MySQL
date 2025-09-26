package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddStudentController {

    @FXML
    private TextField ID;

    @FXML
    private Button addBtn;

    @FXML
    private DatePicker dateOfBirth;

    @FXML
    private TextField fullName;

    @FXML
    private void handleAddStudent() {

        try {
            // Get the values from the form
            String fullNameValue = fullName.getText();
            String idValue = ID.getText();
            LocalDate dateOfBirthValue = dateOfBirth.getValue();

            // Format the date as 'YYYY-MM-DD'
            Date formattedDate = Date.valueOf(dateOfBirthValue);

            // Your database code to insert the data
            // You need to use a PreparedStatement to avoid SQL injection
            Connection connection = App.getInstance().getConnection();
            String sql = "INSERT INTO students (student_id, student_name, date_of_birth) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, idValue);
                preparedStatement.setString(2, fullNameValue);
                preparedStatement.setDate(3, formattedDate);

                int affectedRows = preparedStatement.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Student added successfully");
                    // Optionally close the stage or handle success
                } else {
                    System.out.println("Failed to add student");
                    // Handle failure, show an alert, etc.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

}
