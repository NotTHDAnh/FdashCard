# FdashCard

FdashCard is a JavaFX desktop flashcard application.  
It allows users to create flashcard sets, add cards, and study them through a simple user interface.

This project was built for learning Java, JavaFX, FXML, JDBC, and SQL Server integration.

---

## Features

- Create flashcard sets
- Add flashcards to a set
- View and study cards
- Delete card sets
- JavaFX UI with FXML and CSS
- SQL Server database connection using JDBC

---

## Technologies Used

- Java
- JavaFX
- FXML
- CSS
- JDBC
- Microsoft SQL Server

---

## Project Structure

```text
FdashCard/
├── src/
│   ├── application/
│   ├── Controller/
│   ├── model/
│   ├── resources/
│   └── utils/
├── bin/
├── FlashCard.jar
└── README.md
```

---

## Requirements

Before running this project, make sure you have:

- Java JDK installed
- JavaFX SDK installed
- Microsoft SQL Server installed
- SQL Server JDBC Driver available in the project
- A database named `FdashCard`

### Optional but recommended
- SQL Server Management Studio (SSMS)

SSMS is not required to run the application, but it is recommended because it makes it easier to create the database and import SQL scripts.

---

## Database Requirement

This project uses **Microsoft SQL Server**.

The application connects using JDBC in `DbUtils.java`:

```java
String url = "jdbc:sqlserver://localhost:1433;databaseName=FdashCard";
```

So the user must have:

- SQL Server running on `localhost`
- port `1433` enabled
- a database named `FdashCard`
- the required tables already created
- valid SQL Server username and password

Current database configuration in the project:

```java
private static final String DB_NAME = "FdashCard";
private static final String DB_USER_NAME = "SA";
private static final String DB_PASSWORD = "12345";
```

> Note: If you publish this repository publicly, you should not keep real credentials in the source code.

---

## Important Note About the Database Script

The full SQL script generated from SQL Server may contain machine-specific file paths like this:

```sql
FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLSERVER\MSSQL\DATA\FdashCard.mdf'
```

Those paths may not work on another computer.

For GitHub, it is better to provide a simpler SQL setup script, for example:

```sql
CREATE DATABASE FdashCard;
GO

USE FdashCard;
GO
```

Then add your `CREATE TABLE` statements after that.

---

## Suggested Database Files for This Repo

It is recommended to include a folder like this:

```text
database/
├── create_database.sql
├── create_tables.sql
└── sample_data.sql
```

---

## Example Database Setup

A user can set up the database with these steps:

1. Install Microsoft SQL Server
2. Open SSMS or another SQL client
3. Create a database named `FdashCard`
4. Run the SQL scripts in the `database/` folder
5. Update `DB_USER_NAME` and `DB_PASSWORD` in `DbUtils.java` if needed
6. Run the Java application

---

## How to Run

### Run from source
Make sure JavaFX is configured in your IDE and SQL Server is running.

### Run JAR
Example:

```bash
java --module-path "C:\path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml -jar FlashCard.jar
```

For Linux/macOS:

```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -jar FlashCard.jar
```

---

## Notes

- This is a desktop application, not a web application
- The JDBC URL is a database connection string, not a website URL
- Users cannot run the project successfully unless the SQL Server database is set up correctly
- SQL Server Management Studio is optional, but SQL Server itself is required unless the database is hosted elsewhere

---

## Future Improvements

- Move database credentials out of source code
- Add sample SQL scripts to the repository
- Add update/delete card features
- Improve error handling
- Package the project with easier setup instructions

---

## Author

Developed as a learning project for practicing Java, JavaFX, and database connectivity.

