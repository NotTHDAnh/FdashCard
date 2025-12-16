# FdashCard 

FdashCard is a desktop flashcard application built with **JavaFX**.  
It allows users to create flashcard sets, add cards, and study them through a clean and modern interface.

This project was developed as a **side project during my second year of university**, mainly to practice **Java**, **JavaFX**, and basic UI/UX design.

---

## ✨ Features

- Create and manage flashcard sets
- Add, delete, and study flashcards
- Card flip animation (front / back)
- Modern UI styled with JavaFX CSS
- Scrollable lists
- Input validation with visual feedback

---

## 🛠 Technologies Used

- **Java 17+**
- **JavaFX**
- **FXML**
- **CSS**
- **MVC architecture**

---

## 📦 Requirements

To run this project, you need:

- **Java JDK 17 or newer**
- **JavaFX SDK for your operating system**
---

## 📂 Project Structure

.
├── src/ # Source code
├── resources/ # Images, fonts, CSS
├── bin/ # Compiled output (generated locally)
├── lib/ # JavaFX SDK (local only, not committed)
├── README.md
└── .gitignore

## ▶️ How to Compile

```bash
javac \
--module-path lib \
--add-modules javafx.controls,javafx.fxml \
-d bin \
$(find src -name "*.java")
▶️ How to Run
bash
Copy code
java \
--module-path lib \
--add-modules javafx.controls,javafx.fxml \
-cp bin \
application.Main
🎯 Purpose
This project was created to practice JavaFX UI development, scene switching, and basic application architecture.
It is not intended for production use.

👤 Author
Second-year university student
Side project for learning Java & JavaFX
