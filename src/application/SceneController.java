package application;


import java.io.IOException;
import java.util.function.Consumer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController {
	private static Stage stage;
	private static Scene scene;
	private static Parent root;
	
	public static <T> T switchToScene(
	        ActionEvent e,
	        String fxml,
	        Consumer<T> controllerAction) throws IOException {

	    FXMLLoader loader = new FXMLLoader(SceneController.class.getResource(fxml));
	    root = loader.load();

		scene = new Scene(root);
		scene.getStylesheets().add(SceneController.class.getResource("application.css").toExternalForm());
	    T controller = loader.getController();
	    controllerAction.accept(controller);

	    stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show();

	    return controller;
	}
	
}
