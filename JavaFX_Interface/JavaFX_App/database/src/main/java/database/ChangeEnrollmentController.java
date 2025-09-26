package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChangeEnrollmentController {
    @FXML
    private Button chgBtn;

    @FXML
    private TextField newprojectID;

    @FXML
    private TextField newstudentID;

    @FXML
    private void handleChangeEnrollment() {
        String studentId = newstudentID.getText();
        String projectId = newprojectID.getText();

        // Validate the input, perform any additional checks as needed

        boolean success = changeEnrollment(studentId, projectId);

        if (success) {
            System.out.println("Enrollment information updated successfully.");
        } else {
            System.out.println("Failed to update enrollment information. Please check your input.");
        }
    }

    private boolean changeEnrollment(String studentId, String projectId) {
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "Robertgabriel1!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Assuming you have an "enrollments" table with columns: student_id, project_id
            String sql = "UPDATE enrollments SET project_id=? WHERE student_id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, projectId);
                statement.setString(2, studentId);

                int rowsAffected = statement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
