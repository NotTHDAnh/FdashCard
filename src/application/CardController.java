package application;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

import Controller.MainController;
import Controller.flashCardController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import model.Card;
import model.CardSet;

public class CardController extends SceneController{

	@FXML private StackPane cardPane;
	@FXML private Text flashCardText;
	@FXML private  Button homeButton;
	@FXML private  Label nameOfSet;
	@FXML private Label currentCardIndex;
	@FXML private Label desc;
	@FXML private Button editButton;
	private CardSet set = new CardSet();
	private Card currentCard = new Card();
	private int index = 0;
	MainController controller;
	private flashCardController fcCtrl;
	
	@FXML
	public void initialize() {
		// TODO Auto-generated constructor stub
		cardPane.setOnMouseClicked(e -> flip(e));
		Image img = new Image(getClass().getResourceAsStream("/images/home.png"));
		ImageView icon = new ImageView(img);
		icon.setFitWidth(24);
		icon.setFitHeight(24);
		icon.setPreserveRatio(true);
		homeButton.setGraphic(icon);
		Image img2 = new Image(getClass().getResourceAsStream("/images/edit.png"));
		ImageView icon2 = new ImageView(img);
		icon2.setFitWidth(24);
		icon2.setFitHeight(24);
		icon2.setPreserveRatio(true);
		icon2.setImage(img2);
		editButton.setGraphic(icon2);
	}
	
	public void switchToHomeScreen(ActionEvent e) throws IOException{
		switchToScene(e, "/application/HomeScreen.fxml",(HomeScreenController c)-> c.setController(controller,fcCtrl));
	}
	
	public void switchToUpdate(ActionEvent e) throws IOException{
		switchToScene(e, "Editing.fxml", (UpdateController c)->c.setCardSets(controller,fcCtrl, index));
	}
	
	public void setCardSets(CardSet set,MainController controller,flashCardController fcCtrl,int index) {
		this.set = set;
		this.controller = controller;
		this.fcCtrl = fcCtrl;
		currentCard = set.getListOfCard().get(index);
		flashCardText.setText(currentCard.getHint());
		currentCardIndex.setText((index+ 1) + "/" + (set.getListOfCard().size()));
		nameOfSet.setText(set.getName() );
		desc.setText(set.getDescription());
	}
	
	public void next(ActionEvent e) {
		this.index++;
		this.index = this.index % set.getListOfCard().size();
		currentCard = set.getListOfCard().get((index) );
		flashCardText.setText(currentCard.getHint());
		currentCardIndex.setText((index+ 1) + "/" + (set.getListOfCard().size()));
	}
	public void  prev(ActionEvent e) {
		this.index--;
		this.index = (this.index + set.getListOfCard().size())% set.getListOfCard().size();
		currentCard = set.getListOfCard().get((index));
		flashCardText.setText(currentCard.getHint());
		currentCardIndex.setText((index+ 1) + "/" + (set.getListOfCard().size()));
	}
	
	public void flip(MouseEvent e) {
	    var half1 = new javafx.animation.RotateTransition(javafx.util.Duration.millis(140), cardPane);
	    half1.setAxis(javafx.geometry.Point3D.ZERO.add(1, 0, 0)); // Y axis
	    half1.setFromAngle(0);
	    half1.setToAngle(90);

	    var half2 = new javafx.animation.RotateTransition(javafx.util.Duration.millis(140), cardPane);
	    half2.setAxis(javafx.geometry.Point3D.ZERO.add(1, 0, 0));
	    half2.setFromAngle(-90);
	    half2.setToAngle(0);

	    half1.setOnFinished(ev -> {
			if(flashCardText.getText().equals(currentCard.getHint())) {
				flashCardText.setText(currentCard.getDescription());
			}
			else {
				flashCardText.setText(currentCard.getHint());
			}
			half2.play();
	    });
	    half1.play();
	}


}
