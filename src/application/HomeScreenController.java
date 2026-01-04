package application;

import java.io.IOException;

import Controller.MainController;
import Controller.flashCardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class HomeScreenController extends SceneController{
	@FXML private Label title;
	@FXML private Button createBtn;
	@FXML private Button loadBtn;
	@FXML private Parent root;
	@FXML private ImageView bgImage;
	MainController controller;
	flashCardController fcCtrl;
	
	public void switchToCreateMenu(ActionEvent e) throws IOException{
		switchToScene(e, "CreateMenu.fxml", (CreateController c)->c.setMainController(controller,fcCtrl));
	}
	public void switchToLoadedMenu(ActionEvent e)  throws IOException{
		switchToScene(e,"ListOfSet.fxml",(ListOfSetController c)->c.setCardSetController(controller,fcCtrl));
	}
	public void setController(MainController controller, flashCardController fcCtrl) {
		this.controller = controller;
		this.fcCtrl = fcCtrl;
	}
}
