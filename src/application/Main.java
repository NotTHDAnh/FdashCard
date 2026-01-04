package application;
	

import Controller.MainController;
import Controller.flashCardController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.Card;
import model.CardSet;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	String[] fonts = {
		    "/fonts/Anton-Regular.ttf",
		    "/fonts/thugolatz.ttf",
		};
	@Override
	public void start(Stage stage) throws Exception {
		MainController mainController = new MainController();
		flashCardController fcCtrl = new flashCardController();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/HomeScreen.fxml"));
		Parent root = loader.load();
		stage.setTitle("FlashCard");
		HomeScreenController controller = loader.getController();
		controller.setController(mainController,fcCtrl);

		for (String f : fonts) {
		    Font.loadFont(getClass().getResourceAsStream(f), 12);
		}

		Scene scene = new Scene(root,Color.LIGHTBLUE);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}
