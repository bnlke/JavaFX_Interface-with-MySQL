package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleteProjectController {
    @FXML
    private Button delBtn;

    @FXML
    private TextField projectID;

    @FXML
    private void handleDeleteProject() {
        try {
            // Get the values for deletion
            String project = projectID.getText();

            // Your database code to delete associated enrollments
            Connection connection = App.getInstance().getConnection();
            try (PreparedStatement preparedStatementEnrollments = connection
                    .prepareStatement("DELETE FROM enrollments WHERE project_id = ?")) {
                preparedStatementEnrollments.setString(1, project);
                preparedStatementEnrollments.executeUpdate();
            }

            String sql = "DELETE FROM projects WHERE project_id = ?";
            try (PreparedStatement preparedStatementStudents = connection.prepareStatement(sql)) {
                preparedStatementStudents.setString(1, project);

                int affectedRows = preparedStatementStudents.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Project deleted successfully");
                    // Optionally update UI or handle success
                } else {
                    System.out.println("No project found with the given ID");
                    // Optionally show a message or handle the case when no student is found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, show user-friendly messages
        }
    }
}
