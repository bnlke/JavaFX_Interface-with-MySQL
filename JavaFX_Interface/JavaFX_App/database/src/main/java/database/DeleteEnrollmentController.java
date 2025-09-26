package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteEnrollmentController {
    @FXML
    private Button delBtn;

    @FXML
    private TextField projectID;

    @FXML
    private TextField studentID;

    @FXML
    private void handleDeleteEnrollment() {
        try {
            // Get the values for deletion
            String project = projectID.getText();
            String student = studentID.getText();

            // Your database code to delete associated enrollments
            Connection connection = App.getInstance().getConnection();
            try (PreparedStatement preparedStatementEnrollments = connection
                    .prepareStatement("DELETE FROM enrollments WHERE project_id = ? AND student_id = ?")) {
                preparedStatementEnrollments.setString(1, project);
                preparedStatementEnrollments.setString(2, student);
                int affectedRows = preparedStatementEnrollments.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Enrollment deleted successfully");
                    // Optionally update UI or handle success
                } else {
                    System.out.println("No enrollment found with the given project and student IDs");
                    // Optionally show a message or handle the case when no enrollment is found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, show user-friendly messages
        }
    }

}
