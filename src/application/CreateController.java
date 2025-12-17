package application;

import java.io.IOException;


import Controller.MainController;
import Controller.flashCardController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Card;

public class CreateController extends SceneController {
	flashCardController fcCtrl;
	MainController  MainCtrl;
	@FXML private TextField title;
	@FXML private TextArea description;
	@FXML private VBox listContainer;
	@FXML private ScrollPane cardsScroll;
	@FXML private Button addButton;
	@FXML private Button createSet;
	@FXML private Label errorMsg;
	@FXML private Button homeButton;

	private void setError(Control c, boolean isError) {
		if(isError) c.getStyleClass().add("error");
		else c.getStyleClass().remove("error");
	}

	public void switchToHomeScreen(ActionEvent e) throws IOException{
		switchToScene(e, "/application/HomeScreen.fxml",(HomeScreenController c)-> c.setController(MainCtrl));
	}
	
	@FXML public void initialize() {
		Image img = new Image(getClass().getResourceAsStream("/images/home.png"));
		ImageView icon = new ImageView(img);
		icon.setFitWidth(24);
		icon.setFitHeight(24);
		icon.setPreserveRatio(true);
		homeButton.setGraphic(icon);

		addCard(null);
	}

	@FXML void addCard(ActionEvent e) {
		HBox row = new HBox(12);
		TextField termField = new TextField();
		termField.setPromptText("Term");
		termField.setPrefWidth(120);
		termField.setMinWidth(120);
		termField.setMinHeight(50);
		termField.setMaxHeight(50);
		termField.setAlignment(Pos.CENTER_LEFT);

		termField.setStyle("-fx-border-color: transparent;");
		termField.setStyle("-fx-padding: 0 2 0 2;");


		TextArea defField = new TextArea();
		defField.setPromptText("Definition");
		defField.setPrefWidth(120);
		defField.setMinWidth(170);
		defField.setPrefRowCount(2);;
		defField.setMinHeight(50);
		defField.setMaxHeight(60);

		defField.setStyle("-fx-padding:0 2 0 2;");
		
		Button deleteBtn = new Button();
		deleteBtn.getStyleClass().add("btn-delete");
		deleteBtn.setMinSize(30, 30);
		deleteBtn.setMaxSize(30, 30);
		Image img = new Image(getClass().getResourceAsStream("/images/trash.png"));
		ImageView icon = new ImageView(img);
		icon.setFitWidth(24);
		icon.setFitHeight(24);
		icon.setPreserveRatio(true);
		deleteBtn.setGraphic(icon);
		deleteBtn.setGraphic(icon);
		deleteBtn.setOnAction(ev -> {
			listContainer.getChildren().remove(row);
		});
		row.setAlignment(Pos.CENTER_LEFT);
		row.setMaxWidth(Double.MAX_VALUE);
		row.setFillHeight(true);
		row.getStyleClass().add("HBox");

		

		row.getChildren().addAll(termField,defField,deleteBtn);
		listContainer.getChildren().add(row);
		if(listContainer.getChildren().size() > 1)
			Platform.runLater(()->cardsScroll.setVvalue(1.0));
	}
	
	void setMainController(MainController mainCtrl){
		this.MainCtrl = mainCtrl;
	}
	
	@FXML void onCreate(ActionEvent e) throws IOException {
		boolean ok =  true;
		
		boolean badTitle = utils.Validation.isValid(title.getText());
		boolean badDesc = utils.Validation.isValid(description.getText());
		setError(title,!badTitle);
		setError(description,!badDesc);
		if(!badTitle || !badDesc) ok = false;
		else ok =  true;



		for(Node n : listContainer.getChildren()) {
			HBox row = (HBox)n;
			TextField term = (TextField) row.getChildren().get(0);
			TextArea def = (TextArea) row.getChildren().get(1);

			
			boolean badTerm = utils.Validation.isValid(term.getText());
			boolean badDef = utils.Validation.isValid(def.getText());
			setError(term,!badTerm);
			setError(def, !badDef);
			if((!badTerm || !badDef)) ok = false;
			else if(ok == true) ok = true;
		}
		if(!ok) {
			errorMsg.setVisible(true);
			if(errorMsg != null) errorMsg.setText("* Please fill all the fields,each fields should be 1500 characters");
		}
		else {
			errorMsg.setVisible(false);
			fcCtrl = new flashCardController();
			fcCtrl.getListOfCard().setName(title.getText());
			fcCtrl.getListOfCard().setDescription(description.getText());
			int autoIcrID = 1;
			for(Node n :listContainer.getChildren()) {
				HBox row = (HBox)n;
				TextField term = (TextField) row.getChildren().get(0);
				TextArea def = (TextArea) row.getChildren().get(1);

				Card newCard = new Card(autoIcrID, term.getText(), def.getText());
				fcCtrl.addCard(newCard);
				++autoIcrID;
			}
			fcCtrl.getListOfCard().setId(MainCtrl.getSize());
			MainCtrl.addSet(fcCtrl.getListOfCard());
			switchToScene(e, "Cards.fxml",(CardController c)->c.setCardSets(fcCtrl.getListOfCard(),MainCtrl));
		}

	}
	
}
