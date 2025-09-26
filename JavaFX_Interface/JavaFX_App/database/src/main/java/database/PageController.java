package database;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PageController {

    @FXML
    private MenuItem changeEnrollmentMenuItem;

    @FXML
    private MenuItem changeProjectMenuItem;

    @FXML
    private MenuItem changeStudentMenuItem;

    @FXML
    private Menu enrollmentsMenu;

    @FXML
    private Menu projectsMenu;

    @FXML
    private ListView<?> studentsListView;

    @FXML
    private void handleAddStudent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddStudent.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Add Student");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleDeleteStudent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteStudent.fxml"));
            Parent root = loader.load();
            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Delete Student");
            addStudentStage.setScene(new Scene(root));
            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleChangeStudent() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangeStudent.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Change Student");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleAddProject() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddProject.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Add Project");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleDeleteProject() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteProject.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Delete Project");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleChangeProject() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangeProject.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Change Project");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleAddEnrollment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddEnrollment.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Add Enrollment");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleDeleteEnrollment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DeleteEnrollment.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Delete Enrollment");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    @FXML
    private void handleChangeEnrollment() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChangeEnrollment.fxml"));
            Parent root = loader.load();

            Stage addStudentStage = new Stage();
            addStudentStage.initModality(Modality.APPLICATION_MODAL);
            addStudentStage.setTitle("Change Enrollment");
            addStudentStage.setScene(new Scene(root));

            addStudentStage.showAndWait(); // Show and wait for the popup to be closed
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

}
