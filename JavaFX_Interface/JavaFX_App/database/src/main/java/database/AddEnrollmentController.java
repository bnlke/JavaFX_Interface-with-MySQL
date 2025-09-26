package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddEnrollmentController {
    @FXML
    private Button addBtn;

    @FXML
    private TextField projectID;

    @FXML
    private TextField studentID;

    @FXML
    private void handleAddEnrollment() {

        try {
            // Get the values from the form
            String studentIDValue = studentID.getText();
            String projectIDValue = projectID.getText();

            // Your database code to insert the data
            Connection connection = App.getInstance().getConnection();
            String sql = "INSERT INTO enrollments (student_id, project_id) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, studentIDValue);
                preparedStatement.setString(2, projectIDValue);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Enrollment added successfully");
                    // Optionally close the stage or handle success
                } else {
                    System.out.println("Failed to add enrollment");
                    // Handle failure, show an alert, etc.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, show user-friendly messages
        }
    }
}
