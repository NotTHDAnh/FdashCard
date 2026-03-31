# FdashCard

FdashCard is a JavaFX desktop flashcard application built with Java, FXML, JDBC, and Microsoft SQL Server.

It allows users to create flashcard sets, add cards, study them, and edit existing cards through a simple desktop interface.

---

## Features

- Create flashcard sets
- Add cards to a set
- Study flashcards
- Edit existing cards
- JavaFX user interface
- SQL Server database integration

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
│   ├── utils/
│   ├── resources/
│   └── db.properties
├── database/
│   └── create_database.sql
├── bin/
├── README.md
└── sqljdbc4.jar
```

---

## Requirements

Before running this project, make sure you have:

- Java JDK installed
- JavaFX SDK installed
- Microsoft SQL Server installed
- SQL Server JDBC Driver
- A database named `FdashCard`

### Recommended
- SQL Server Management Studio (SSMS)

SSMS is optional, but it makes database setup easier on Windows.

---

## Database Setup

This project uses **Microsoft SQL Server**.

### 1. Create the database

A database creation script is already included in the project:

```text
database/create_database.sql
```

Run that file first in SQL Server.

### 2. Run your table creation script
After creating the database, run your `CREATE TABLE` statements and optional sample data scripts.

### 3. Configure database connection
Create a file named `db.properties` inside `src/`:

```properties
db.url=jdbc:sqlserver://localhost:1433;databaseName=FdashCard;encrypt=true;trustServerCertificate=true
db.user=YOUR_USERNAME
db.password=YOUR_PASSWORD
```

---

## Important Note

The full SQL Server script generated from SSMS may include machine-specific file paths like:

```sql
FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLSERVER\MSSQL\DATA\FdashCard.mdf'
```

Those paths may not work on another computer.

For GitHub, it is better to share:
- a simple `CREATE DATABASE` script
- table creation scripts
- optional sample data scripts

If your included database script still contains machine-specific file paths, another user may need to edit it before running it.

---

## Running the Project from Source

### Windows

#### Compile

```powershell
New-Item -ItemType Directory -Force bin
$files = Get-ChildItem -Recurse -Path .\src -Filter *.java | ForEach-Object { $_.FullName }
javac --module-path "C:\java-fx_25\lib" --add-modules javafx.controls,javafx.fxml -cp ".;.\sqljdbc4.jar" -d bin $files
```

#### Copy resources

```powershell
New-Item -ItemType Directory -Force .\bin\application
Copy-Item .\src\application\*.fxml .\bin\application\ -Force
Copy-Item .\src\application\*.css .\bin\application\ -Force
Copy-Item .\src\db.properties .\bin\db.properties -Force
Copy-Item .\src\resources -Destination .\bin\resources -Recurse -Force
```

#### Run

```powershell
java --module-path "C:\java-fx_25\lib" --add-modules javafx.controls,javafx.fxml -cp ".;bin;.\sqljdbc4.jar" application.Main
```

### Linux

#### Compile

```bash
mkdir -p bin
javac --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp "./sqljdbc4.jar" -d bin $(find ./src -name "*.java")
```

#### Copy resources

```bash
mkdir -p ./bin/application
cp ./src/application/*.fxml ./bin/application/
cp ./src/application/*.css ./bin/application/
cp ./src/db.properties ./bin/db.properties
cp -r ./src/resources ./bin/
```

#### Run

```bash
java --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp "./bin:./sqljdbc4.jar" application.Main
```

### macOS

#### Compile

```bash
mkdir -p bin
javac --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp "./sqljdbc4.jar" -d bin $(find ./src -name "*.java")
```

#### Copy resources

```bash
mkdir -p ./bin/application
cp ./src/application/*.fxml ./bin/application/
cp ./src/application/*.css ./bin/application/
cp ./src/db.properties ./bin/db.properties
cp -r ./src/resources ./bin/
```

#### Run

```bash
java --module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml -cp "./bin:./sqljdbc4.jar" application.Main
```

> On Linux and macOS, replace `/path/to/javafx/lib` with the actual location of your JavaFX SDK.

---

## Running in Eclipse

1. Import the project into Eclipse
2. Make sure `src` is marked as a source folder
3. Add JavaFX libraries
4. Add the SQL Server JDBC driver
5. Make sure `db.properties` exists in `src`
6. Run `application.Main`

### VM Arguments for JavaFX

#### Windows

```bash
--module-path "C:\java-fx_25\lib" --add-modules javafx.controls,javafx.fxml
```

#### Linux/macOS

```bash
--module-path "/path/to/javafx/lib" --add-modules javafx.controls,javafx.fxml
```

Optional:

```bash
--enable-native-access=javafx.graphics
```

---

## Notes

- This is a desktop application, not a web application
- The JDBC URL is a database connection string, not a website URL
- SQL Server must be installed and configured before running the app
- SQL Server Management Studio is optional
- If resources such as `.fxml`, `.css`, or images are not copied correctly, the app may fail at runtime
- The included database creation file should be run before starting the application

---

## Future Improvements

- Move sensitive database config fully out of source
- Add sample SQL scripts to the repository
- Improve validation and error handling
- Improve empty-state UI for sets with no cards
- Package the project for easier setup

---

## Author

Developed as a JavaFX and SQL Server learning project.

