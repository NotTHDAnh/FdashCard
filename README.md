# FdashCard 

FdashCard is a desktop flashcard application built using **JavaFX**.  
It allows users to create flashcard sets, add cards, and study them with a clean and modern interface.

This project was developed as a **side project during my second year of university**, mainly to practice **Java**, **JavaFX**, and UI/UX design.

---

##  Features

- Create and manage flashcard sets
- Add, delete, and study flashcards
- Card flip animation (front / back)
- Modern UI styled with JavaFX CSS
- Scrollable card lists
- Input validation with visual feedback

---

##  Technologies Used

- **Java 25**
- **JavaFX 25**
- **FXML**
- **CSS**
- **MVC architecture**

---

##  Requirements

To run this project, you need:

- **Java JDK 25 or newer**
- **JavaFX SDK** (included in the project)
- **JavaFX 25** Required

This application **requires JavaFX** and will NOT run without it.

JavaFX is **not bundled with Java** and is **not included in this repository**.

### Install JavaFX
1. Download JavaFX from:  
   https://openjfx.io/
2. Extract it somewhere on your machine  
   (example: `C:\javafx\lib`)

---

##  Project Structure

```
.
├── bin/            # Compiled .class files (Eclipse output)
├── src/            # Source code
├── lib/            # JavaFX libraries
├── resources/      # Images, fonts
├── FlashCard.jar   # executable jar file
└── README.md
```

---

---
##  Compile & Run

###  Windows (CMD)
#### Run

```bash
java --module-path "C:\path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml -jar FlashCard.jar

```

### Linux, MacOS
#### Run
```bash
java \
--module-path /path/to/javafx/lib \
--add-modules javafx.controls,javafx.fxml \
-jar \
FlashCard.jar
```
---

##  Purpose of This Project

This project was created to:

- Practice **JavaFX UI development**
- Learn **scene switching and controller communication**
- Improve **UI/UX design skills**
- Apply **clean code and MVC principles**

This is a **learning-focused project**, not production software.

---

## 👤 Author
Me

Side project for learning Java & JavaFX
