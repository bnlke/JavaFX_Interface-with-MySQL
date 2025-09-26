package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class ChangeStudentController {
    @FXML
    private TextField ID;

    @FXML
    private Button chgBtn;

    @FXML
    private DatePicker dateOFBirth;

    @FXML
    private TextField newfullName;

    @FXML
    private void handleChangeStudent() {
        // Get values from the input fields
        String studentId = ID.getText();
        String newStudentName = newfullName.getText();
        String newDateOfBirth = dateOFBirth.getValue().toString(); // Convert DatePicker value to String
        boolean success = updateStudentInfo(studentId, newStudentName, newDateOfBirth);
        // Display a success or error message based on the update result
        if (success) {
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Failed to update student information. Please check your input.");
        }
    }

    // Example method for updating student information in the database
    private boolean updateStudentInfo(String studentId, String newStudentName, String newDateOfBirth) {
        // JDBC connection parameters (replace with your database details)
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "Robertgabriel1!";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL update query
            String sql = "UPDATE students SET student_name=?, date_of_birth=? WHERE student_id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newStudentName);
                statement.setString(2, newDateOfBirth);
                statement.setString(3, studentId);
                // Execute the update query
                int rowsAffected = statement.executeUpdate();
                // Return true if at least one row is affected, indicating a successful update
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
