package database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static App instance;
    private static Connection connection;

    @Override
    public void start(Stage stage) throws IOException {
        instance = this; // Initialize the instance
        // Establish the database connection
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle connection errors
        }
        scene = new Scene(loadFXML("page"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL resource = App.class.getResource(fxml + ".fxml");
        if (resource == null) {
            throw new IOException("FXML file not found: " + fxml);
        }
        System.out.println("FXML Resource: " + resource);
        FXMLLoader fxmlLoader = new FXMLLoader(resource);
        return fxmlLoader.load();
    }

    String error;
    Connection con;

    public void connect() throws ClassNotFoundException, SQLException, Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database",
                    "root", "your_password");
            connection = con; // Initialize the connection variable
        } catch (ClassNotFoundException | SQLException e) {
            throw e; // Rethrow the exception to handle it appropriately
        } catch (Exception e) {
            throw e; // Rethrow the exception to handle it appropriately
        }
    }

    // Other methods...

    public void disconnect() throws SQLException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqle) {
            error = ("SQLException: Nu se poate inchide conexiunea la baza de date.");
            throw new SQLException(error);
        }
    }

    public static App getInstance() {
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        launch();
    }

}