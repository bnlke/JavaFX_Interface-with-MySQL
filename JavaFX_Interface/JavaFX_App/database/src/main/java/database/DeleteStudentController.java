package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteStudentController {
    @FXML
    private TextField ID;

    @FXML
    private Button delBtn;

    @FXML
    private void handleDeleteStudent() {
        try {
            // Get the values for deletion
            String studentID = ID.getText();
            // Your database code to delete associated enrollments
            Connection connection = App.getInstance().getConnection();
            try (PreparedStatement preparedStatementEnrollments = connection
                    .prepareStatement("DELETE FROM enrollments WHERE student_id = ?")) {
                preparedStatementEnrollments.setString(1, studentID);
                preparedStatementEnrollments.executeUpdate();
            }
            String sql = "DELETE FROM students WHERE student_id = ?";
            try (PreparedStatement preparedStatementStudents = connection.prepareStatement(sql)) {
                preparedStatementStudents.setString(1, studentID);
                int affectedRows = preparedStatementStudents.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Student deleted successfully");
                    // Optionally update UI or handle success
                } else {
                    System.out.println("No student found with the given ID");
                    // Optionally show a message or handle the case when no student is found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, show user-friendly messages
        }
    }
}
