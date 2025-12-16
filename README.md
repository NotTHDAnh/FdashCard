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

- **Java 17+**
- **JavaFX**
- **FXML**
- **CSS**
- **MVC architecture**

---

##  Requirements

To run this project, you need:

- **Java JDK 17 or newer**
- **JavaFX SDK** (included in the project)

No additional installation of JavaFX is required.

---

##  Project Structure

```
.
├── bin/            # Compiled .class files (Eclipse output)
├── src/            # Source code
├── lib/            # JavaFX libraries
├── resources/      # Images, fonts
└── README.md
```

---

##  How to Compile

```bash
javac \
--module-path lib \
--add-modules javafx.controls,javafx.fxml \
-d bin \
$(find src -name "*.java")
```

---

##  How to Run

From the **project root directory**, run:

```bash
java \
--module-path lib \
--add-modules javafx.controls,javafx.fxml \
-cp bin \
application.Main
```

> Make sure you execute this command **inside the project folder**.

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

Side project for learning Java & JavaFX
