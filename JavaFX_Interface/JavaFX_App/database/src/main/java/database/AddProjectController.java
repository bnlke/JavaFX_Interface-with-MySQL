package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddProjectController {
    @FXML
    private TextField ID;

    @FXML
    private Button addBtn;

    @FXML
    private TextArea projectDescription;

    @FXML
    private TextField projectName;

    @FXML
    private void handleAddProject() {
        try {
            // Get the values from the form
            String projectIDValue = ID.getText();
            String projectNameValue = projectName.getText();
            String projectDescriptionValue = projectDescription.getText();

            // Your database code to insert the data
            Connection connection = App.getInstance().getConnection();
            String sql = "INSERT INTO projects (project_id, project_name, project_description) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, projectIDValue);
                preparedStatement.setString(2, projectNameValue);
                preparedStatement.setString(3, projectDescriptionValue);

                int affectedRows = preparedStatement.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Project added successfully");
                    // Optionally close the stage or handle success
                } else {
                    System.out.println("Failed to add project");
                    // Handle failure, show an alert, etc.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exceptions appropriately, show user-friendly messages
        }
    }
}
