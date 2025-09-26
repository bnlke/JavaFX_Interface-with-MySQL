package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChangeProjectController {
    @FXML
    private TextField ID;

    @FXML
    private Button chgBtn;

    @FXML
    private TextArea chgDescription;

    @FXML
    private TextField newprojectName;

    @FXML
    private void handleChangeProject() {
        // Get values from the input fields
        String projectId = ID.getText();
        String newProjectName = newprojectName.getText();
        String newDescription = chgDescription.getText();

        // Validate the input, perform any additional checks as needed

        // Perform the database update or any other action based on your requirements
        boolean success = updateProjectInfo(projectId, newProjectName, newDescription);

        // Display a success or error message based on the update result
        if (success) {
            System.out.println("Project information updated successfully.");
        } else {
            System.out.println("Failed to update project information. Please check your input.");
        }
    }

    // Example method for updating project information in the database
    private boolean updateProjectInfo(String projectId, String newProjectName, String newDescription) {
        // JDBC connection parameters (replace with your database details)
        String url = "jdbc:mysql://localhost:3306/university";
        String username = "root";
        String password = "Robertgabriel1!";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // SQL update query
            String sql = "UPDATE projects SET project_name=?, project_description=? WHERE project_id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, newProjectName);
                statement.setString(2, newDescription);
                statement.setString(3, projectId);

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
