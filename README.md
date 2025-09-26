🎓 Student & Project Management App (JavaFX + MySQL)
This is a desktop application built with JavaFX (designed using Scene Builder) and connected to a MySQL database. The application allows full CRUD (Create, Read, Update, Delete) operations for managing students and their academic projects within a university context.

📌 Features
🔍 View all students and their assigned projects
➕ Add new students and projects
✏️ Edit existing records
🗑️ Delete students or projects
🔗 Link students to specific projects
📋 Display data using JavaFX TableViews
🧰 Technologies Used
Java 21+
JavaFX – UI framework
Scene Builder – for UI layout design (FXML)
MySQL – relational database
JDBC – for Java-MySQL connectivity
(Optional) Maven or Gradle for project management
🚀 Quick Start
Follow these steps to run the application locally:

1. Clone the repository
If you use Git, run:

git clone https://github.com/bnlke/JavaFX-Interface-with-MySQL-Database.git
cd JavaFX-Interface-with-MySQL-Database

2. Import the project into Visual Studio Code

Go to File → Open Folder...
Select the JavaFX_Interface folder.
If you're using extensions like Java Extension Pack, it will auto-detect and index the project.

3. Install MySQL & Set Up the Database

Make sure MySQL is installed and running locally.
Create a new database:

CREATE DATABASE university_db;
USE university_db;

-- Sample (dump.sql):
CREATE TABLE students (...);
CREATE TABLE projects (...);
-- etc.

4. Configure the database connection in code

Open the file App.java and update the credentials:

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database",
                    "root", "your_password");

Make sure:

MySQL is running on port 3306
You have the correct username & password
The database name matches (university_db)

5. Set up JavaFX in your environment

Download JavaFX SDK
Extract it to a known location, e.g., C:\javafx-sdk-21\
In VS Code, go to Run and Debug → Configure launch.json
Add the following to VM options:

"vmArgs": "--module-path "C:/javafx-sdk-21/lib" --add-modules javafx.controls,javafx.fxml"

6. Run the application

Open App.java inside JavaFX_Interface
Click Run
The JavaFX interface should load
You can now interact with the database: add, edit, or delete students and projects
