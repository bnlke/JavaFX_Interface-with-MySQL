# 🎓 Student & Project Management App (JavaFX + MySQL)

This is a desktop application built with **JavaFX** (designed using Scene Builder) and connected to a **MySQL** database. The application allows full **CRUD** (Create, Read, Update, Delete) operations for managing students and their academic projects within a university context.

---

## 📌 Features

- 🔍 View all students and their assigned projects  
- ➕ Add new students and projects  
- ✏️ Edit existing records  
- 🗑️ Delete students or projects  
- 🔗 Link students to specific projects  
- 📋 Display data using JavaFX `TableView` components  

---

## 🧰 Technologies Used

| Component     | Technology                  |
|---------------|------------------------------|
| Language      | Java 21+                     |
| UI Framework  | JavaFX (FXML)               |
| UI Design     | Scene Builder               |
| Database      | MySQL                       |
| Connectivity  | JDBC                        |
| Project Build | (Optional) Maven or Gradle  |
| IDE           | Visual Studio Code          |

---

## 🚀 Quick Start

Follow these steps to run the application locally:

---

### 1. Clone the Repository

If you use Git, run:

```bash
git clone https://github.com/bnlke/JavaFX-Interface-with-MySQL-Database.git
cd JavaFX-Interface-with-MySQL-Database

2. Import the Project into Visual Studio Code

3. Install MySQL & Set Up the Database

Make sure MySQL is installed and running locally.
Create the database and the tables.

4. Configure the Database Connection in Code

Open the file App.java and update your connection string:

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/your_database",
    "root",
    "your_password"
);

5. Set Up JavaFX in Your Environment

Download JavaFX SDK
Extract it to a known location (e.g. C:\javafx-sdk-21\)
In VS Code, go to:
Run and Debug → create launch.json
Add the following in the vmArgs field: "vmArgs": "--module-path C:/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml"

6. Run the Application

Open the file App.java inside the JavaFX_Interface folder
Click Run
The JavaFX interface should start
You can now add, view, edit, or delete students and projects via the UI
